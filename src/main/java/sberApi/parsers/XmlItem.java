package sberApi.parsers;

import java.nio.charset.StandardCharsets;

/**
 * Created by orlovsauser on 23.05.2021.
 */

public class XmlItem {
    private String NomerStroki;
    private String NomerDogovora;
    private String DataDogovora;
    private String DeponiruemaiaSumma;
    private String NaimenovanieGK;
    private String NomerUchastka;
    private String UslovnyNomerObiekta;
    private String Dolshik;
    private String TipDocumenta;
    private String SeriyaDoc;
    private String NomerDoc;
    private String DataVidachiDoc;
    private String KemVidanDoc;
    private String AdresRegistracii;
    private String AdresProgivatia;
    private String Telefon;
    private String ElektrPochta;

    private String date;
    private String mode;
    private String unit;
    private String current;
    private String interactive;

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getCurrent() {
        return current;
    }
    public void setCurrent(String current) {
        this.current = current;
    }
    public String getInteractive() {
        return interactive;
    }
    public void setInteractive(String interactive) {
        this.interactive = interactive;
    }
    public String getLastName(){
        return Dolshik.split(" ")[0];
    }
    public String getMidlName(){
        return Dolshik.split(" ")[2];
    }
    public String getFirstName(){
        return Dolshik.split(" ")[1];
    }


// Методы для 1С
public String getNomerStroki() {
    return NomerStroki;
}
    public String getNomerDogovora() {
        return NomerDogovora;
    }
    public String getDataDogovora() {
        return DataDogovora;
    }
    public String getDeponiruemaiaSumma() {
        return DeponiruemaiaSumma;
    }
    public String getNaimenovanieGK() {
        return NaimenovanieGK;
    }
    public String getNomerUchastka() {
        return NomerUchastka;
    }
    public String getUslovnyNomerObiekta() {
        return UslovnyNomerObiekta;
    }
    public String getDolshik() {
        return Dolshik;
    }
    public String getTipDocumenta() {
        return TipDocumenta;
    }
    public String getSeriyaDoc() {
        return SeriyaDoc;
    }
    public String getNomerDoc() {
        return NomerDoc;
    }
    public String getDataVidachiDoc() {
        return DataVidachiDoc;
    }
    public String getKemVidanDoc() {
        return KemVidanDoc;
    }
    public String getAdresRegistracii() {
        return AdresRegistracii;
    }
    public String getAdresProgivatia() {
        return AdresProgivatia;
    }
    public String getTelefon() {
        return Telefon;
    }
    public String getElektrPochta() {
        return ElektrPochta;
    }
    public void setNomerStroki(String date) {
        this.NomerStroki = date;
    }
    public void setNomerDogovora(String date) {

        this.NomerDogovora = date.trim();

    }
    public void setDataDogovora(String date) {
        this.DataDogovora = date;
    }
    public void setDeponiruemaiaSumma(String date) {
        this.DeponiruemaiaSumma = date;
    }
    public void setNaimenovanieGK(String date) {
        this.NaimenovanieGK = date;
    }
    public void setNomerUchastka(String date) {
        this.NomerUchastka = date;
    }
    public void setUslovnyNomerObiekta(String date) {
        this.UslovnyNomerObiekta = date.trim();
    }
    public void setDolshik(String date) {
        this.Dolshik = date;
    }
    public void setTipDocumenta(String date) {
        this.TipDocumenta = date.trim();
    }
    public void setSeriyaDoc(String date) {
        this.SeriyaDoc = date;
    }
    public void setNomerDoc(String date) {
        this.NomerDoc = date;
    }
    public void setDataVidachiDoc(String date) {
        this.DataVidachiDoc = date;
    }
    public void setKemVidanDoc(String date) {
        this.KemVidanDoc = date;
    }
    public void setAdresRegistracii(String date) {
        this.AdresRegistracii = date;
    }
    public void setAdresProgivatia(String date) {
        this.AdresProgivatia = date;
    }
    public void setTelefon(String date) {

        // Убираем скобочки и пробелы
        String newdate;
        newdate = date.replace("(","");
        newdate = newdate.replace(")","");
        newdate = newdate.replace(" ","");
        newdate = newdate.replace("-","");

        this.Telefon = newdate;
    }
    public void setElektrPochta(String date) {
        this.ElektrPochta = date;
    }



    @Override
    public String toString() {
        return "XmlItem{" +
                "NomerStroki=" + NomerStroki +
                ", \nNomerDogovora='" + NomerDogovora + '\'' +
                ", \nDataDogovora='" + DataDogovora + '\'' +
                ", \nDeponiruemaiaSumma=" + DeponiruemaiaSumma +
                ", \nNaimenovanieGK='" + NaimenovanieGK + '\'' +
                ", \nNomerUchastka='" + NomerUchastka + '\'' +
                ", \nUslovnyNomerObiekta='" + UslovnyNomerObiekta + '\'' +
                ", \nDolshik='" + Dolshik + '\'' +
                ", \nTipDocumenta='" + TipDocumenta + '\'' +
                ", \nSeriyaDoc='" + SeriyaDoc + '\'' +
                ", \nNomerDoc='" + NomerDoc + '\'' +
                ", \nDataVidachiDoc='" + DataVidachiDoc + '\'' +
                ", \nKemVidanDoc='" + KemVidanDoc + '\'' +
                ", \nAdresRegistracii='" + AdresRegistracii + '\'' +
                ", \nAdresProgivatia='" + AdresProgivatia + '\'' +
                ", \nTelefon='" + Telefon + '\'' +
                ", \nElektrPochta='" + ElektrPochta + '\'' +
                '}'+"\n";
    }
}
