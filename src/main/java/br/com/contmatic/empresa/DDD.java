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
    BAURU(14),
    SOROCABA(15),
    RIBEIRAO_PRETO(16),
    SAO_JOSE_DO_RIO_PRETO(17),
    PRESIDENTE_PRUDENTE(18),
    CAMPINAS(19),
    RIO_DE_JANEIRO(21),
    CAMPOS_DOS_GOYTACAZES(22),
    VOLTA_REDONDA(24),
    VITORIA(27),
    CACHOEIRO_DE_ITAPEMIRIM(28),
    BELO_HORIZONTE(31),
    JUIZ_DE_FORA(32),
    GOVERNADOR_VALADARES(33),
    UBERLANDIA(34),
    POCOS_DE_CALDAS(35),
    DIVINOPOLIS(37),
    MONTES_CLAROS(38),
    CURITIBA(41),
    PONTA_GROSSA(42),
    LONDRINA(43),
    MARINGA(44),
    FOZ_DO_IGUACU(45),
    PATO_BRANCO(46),
    JOINVILLE(47),
    FLORIANOPOLIS(48),
    CHAPECO(49),
    PORTO_ALEGRE(51),
    PELOTAS(53),
    CAXIAS_DO_SUL(54),
    SANTA_MARIA(55),
    BRASILIA(61),
    GOIANIA(62),
    PALMAS(63),
    RIO_VERDE(64),
    CUIABA(65),
    RONDONOPOLIS(66),
    CAMPO_GRANDE(67),
    RIO_BRANCO(68),
    PORTO_VELHO(69),
    SALVADOR(71),
    ILHEUS(73),
    JUAZEIRO(74),
    FEIRA_DE_SANTANA(75),
    BARREIRAS(77),
    ARACAJU(79),
    RECIFE(81),
    MACEIO(82),
    JOAO_PESSOA(83),
    NATAL(84),
    FORTALEZA(85),
    TERESINA(86),
    PETROLINA(87),
    JUAZEIRO_DO_NORTE(88),
    PICOS(89),
    BELEM(91),
    MANAUS(92),
    SANTAREM(93),
    MARABA(94),
    BOA_VISTA(95),
    MACAPA(96),
    COARI(97),
    SAO_LUIS(98),
    IMPERATRIZ(99);


    private final Integer codigoDDD;

    private DDD(int codigoDDD) {
        this.codigoDDD = codigoDDD;
    }

    public Integer getCodigoDDD() {
        return this.codigoDDD;
    }

}
