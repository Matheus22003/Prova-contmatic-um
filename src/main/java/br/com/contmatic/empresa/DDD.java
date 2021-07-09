package br.com.contmatic.empresa;

/**
 * Enum que contém todos os estados brasileiros e seus respectivos .
 *
 * @author Matheus de Oliveira Simões
 */
public enum DDD {
    SAO_PAULO(11),
    SAO_JOSE_DOS_CAMPOS(12),
    SANTOS(13),
    RR(14),
    PA(15),
    AP(16),
    TO(17),
    MA(21),
    PI(22),
    CE(23),
    RN(24),
    PB(25),
    PE(26),
    AL(27),
    SE(28),
    BA(29),
    MG(31),
    ES(32),
    RJ(33),
    SP(35),
    PR(41),
    SC(42),
    RS(43),
    MS(50),
    MT(51),
    GO(52),
    DF(53);

    private final Integer codigoDDD;

    private DDD(int codigoDDD) {
        this.codigoDDD = codigoDDD;
    }

    public Integer getCodigoDDD() {
        return this.codigoDDD;
    }

}
