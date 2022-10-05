package br.com.letsCode.model;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class mapaAstral {


    public static String calcularIdade(LocalDate dataNascimento){
        return Period.between(dataNascimento, LocalDate.now()).toString().substring(1);
    }

    public static String verificarAnoBissexto(Year ano) {
        boolean foiBissexto = ano.isLeap();

        if (foiBissexto) return "Sim";
        else return "Não";
    }

    public static String formatarData (LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return formatter.format(data);
    }

    public static ZoneOffset verificarTimeZone(String local, LocalDateTime dataHora) {
        ZoneId zoneId= ZoneId.of(local);
        return zoneId.getRules().getOffset(dataHora);
    }

    public static String verificarSigno(MonthDay aniversario) {
        MonthDay leaoComecaEm = MonthDay.of(7,22);
        MonthDay leaoTerminaEm = MonthDay.of(8,23);

        MonthDay sagitarioComecaEm = MonthDay.of(11,21);
        MonthDay sagitarioTerminaEm = MonthDay.of(12,22);

        if (verificarSeEstaEntreDatas(aniversario, leaoComecaEm, leaoTerminaEm)) return "Leão";

        if (verificarSeEstaEntreDatas(aniversario, sagitarioComecaEm, sagitarioTerminaEm)) return "Sagitário";

        return "Ainda não foi cadastrado um signo para a data informada";
    }


    private static boolean verificarSeEstaEntreDatas(MonthDay dataParaVerificar, MonthDay dataInicio, MonthDay dataFim) {
        return !(dataParaVerificar.isBefore(dataInicio) || dataParaVerificar.isAfter(dataFim)) ;
    }

    public static String ascendente(String signo, LocalTime horarioDeNascimento) {
        if ("Leão".equalsIgnoreCase(signo)) {
            if (verificarSeEstaEntreHorarios(horarioDeNascimento, LocalTime.of(18, 0), LocalTime.of(19, 59))) return "Áries";
        }
        if ("Sagitário".equalsIgnoreCase(signo)) {
            if (verificarSeEstaEntreHorarios(horarioDeNascimento, LocalTime.of(12, 0), LocalTime.of(13, 59))) return "Peixes";
        }
        return "Ascendente não encontrado";
    }

    private static boolean verificarSeEstaEntreHorarios(LocalTime horaParaVerificar, LocalTime horaInicio, LocalTime horaFim) {
        return !(horaParaVerificar.isBefore(horaInicio) || horaParaVerificar.isAfter(horaFim)) ;
    }

    public static String signoLunar (String localNascimento, LocalTime horaNascimento){

        if (localNascimento == "America/Sao_Paulo") return "Gandalf";

        if (localNascimento == "America/Recife" && horaNascimento.isAfter(LocalTime.of(12, 0))) return "Casimiro";

        if (localNascimento == "America/Cuiaba" && horaNascimento.isBefore(LocalTime.of(12, 0))) return "Odin";

        return "Em construção";
    }



}
