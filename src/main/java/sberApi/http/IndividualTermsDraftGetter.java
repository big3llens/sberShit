package sberApi.http;

import okhttp3.*;
import sberApi.parsers.XmlItem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IndividualTermsDraftGetter {
    public static String getIndividualTermsDraft(XmlItem item, String token) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "escrowAmount=" + item.getDeponiruemaiaSumma() + "&depositorLastName=" +
                item.getLastName() + "&depositorFirstName=" + item.getFirstName() + "&depositorMiddleName=" + item.getMidlName() + "&depositorRegistrationAddress=" +
                item.getAdresRegistracii() + "&depositorCurrentAddress=" + item.getAdresProgivatia() + "&depositorIdentificationDocumentType=" +
                99 + "&depositorIdentificationDocumentSeries=" + item.getSeriyaDoc() + "&depositorIdentificationDocumentNumber=" +
                item.getNomerDoc() + "&depositorIdentificationDocumentIssuer=" + item.getKemVidanDoc() + "&depositorIdentificationDocumentIssueDate=" +
                item.getDataVidachiDoc() + "&depositorPhone=" + item.getTelefon() + "&depositorEmail=" + item.getElektrPochta() + "&beneficiaryTaxId=" +
                "7811387979" + "&beneficiaryAuthorizedRepresentativeCertificateSerial=" + "569868924406069926552253" + "&equityParticipationAgreementNumber=" +
                item.getNomerDogovora() + "&equityParticipationAgreementDate=" + item.getDataDogovora() + "&estateObjectType=" + "RESIDENTIAL" + "&estateObjectCommisioningObjectCode=" +
                "5901" + "&estateObjectConstructionNumber=" + item.getUslovnyNomerObiekta());

        Request request = new Request.Builder()
//                + item.getDeponiruemaiaSumma() +
                .url("https://dev.api.sberbank.ru/ru/prod/v2/escrow/individual-terms/draft")
                .post(body)
                .addHeader("x-ibm-client-id", "0a46d7fc-bc05-4a38-ab1d-355b13c5ba32")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("x-introspect-rquid", "1e10c472a8be11ebbcbc0242ac130002")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("accept", "application/xml")
                .build();

        Response response;

        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
