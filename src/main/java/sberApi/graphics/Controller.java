package sberApi.graphics;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sberApi.beans.Token;
import sberApi.http.IndividualTermsDraftGetter;
import sberApi.http.TokenGetter;
import sberApi.parsers.XmlItem;
import sberApi.parsers.XmlParser;
import java.util.Date;

public class Controller {
    @FXML
    TextField findField;
    @FXML
    TextArea userArea;

    private final Token token;

    public Controller() {
        token = new Token(new Date(), TokenGetter.getToken());
    }

    public void findContract() {
        if (token.getExpiredDate().getTime() < System.currentTimeMillis()) token.setToken(TokenGetter.getToken());
        XmlItem xmlItem = XmlParser.startProgram(findField.getText());
        if (xmlItem == null)userArea.setText("К сожалению клиента с указанным номером договора найти не удалось");
//        else userArea.setText(xmlItem.toString());
        else {
            userArea.setText(IndividualTermsDraftGetter.getIndividualTermsDraft(xmlItem, token.getToken()));
//            userArea.setText(ResidentialComplexGetter.getResidentialComplex(TokenGetter.getToken()));
//            userArea.setText(TokenGetter.getToken());
//                System.out.println(TokenGetter.getToken().string());
        }
        findField.setText("");
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
    }
}
