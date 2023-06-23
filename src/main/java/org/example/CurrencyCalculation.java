package org.example;

public class CurrencyCalculation {

    String buy = "not set";
    String sell = "not set";

    /**
     * @param buy Währung die umgerechnet werden soll.
     */

    public void setBuy(String buy) {

        this.buy = buy;
    }

    public String getBuy() {

        return buy;
    }

    /**
     * @param sell Währung, in die umgerechnet und ausgegeben werden soll.
     */

    public void setSell(String sell) {

        this.sell = sell;
    }

    public String getSell() {

        return sell;
    }

    /**
     * @param amount Der User gibt über die Konsole einen Betrag ein, der über folgende Methode umgerechnet wird.
     *               Die gesetzte buy-Währung wird mithilfe von SDR in die angefragte sell-Währung umgerechnet.
     * @return Gibt den umgerechneten Betrag zurück. Wenn der über die Konsole eingetragene Betrag negativ ist,
     * wird 0 ausgegeben, da keine negativen Werte möglich sind.
     */


    public double calculationAmount(double amount) {
        if (amount >= 0) {

            Currencys[] finalCurrency = ImportFile.importFile();

            double sdrBuy = 0.0;
            double sdrSell = 0.0;

            for (Currencys element : finalCurrency) {

                if (element.containsString(buy)) {
                    sdrBuy = element.getSdr();
                }
            }

            for (Currencys element : finalCurrency) {

                if (element.containsString(sell)) {
                    sdrSell = element.getSdr();
                }
            }

            return (amount / sdrBuy) * sdrSell;
        }
        return 0;


    }

}
