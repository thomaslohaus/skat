/**
 * Javascript
 */

$("input[type='checkbox']").change(function() {
	if (this.checked) {
		incluirJogadorNoCampeonato($(this).attr('id').substring(7));
	}
	else {
		alert("unchecked");
	}
});

function incluirJogadorNoCampeonato(jogador) {
	var url = "incluirJogador?idJogador=" + jogador
	$.ajax({  
	    tytype: "GET",
	    contentType: "application/json; charset=utf-8",
	    url: url,
	    dataType: "json",
	    success: function(data, textStatus, xhr){
	    	alert(data.nome);
	    },
	    error: function(xhr, textStatus, errorThrown){ alert("Erro!"); }
	});
}


$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 7, // Creates a dropdown of 15 years to control year,
    
    format: 'dd/mm/yyyy',
	formatSubmit: 'dd/mm/yyyy',
	//hiddenName: true,
    
    // The title label to use for the month nav buttons
    labelMonthNext: 'Mês seguinte',
    labelMonthPrev: 'Mês anterior',

    // The title label to use for the dropdown selectors
    labelMonthSelect: 'Selecione um mês',
    labelYearSelect: 'Selecione um ano',

    // Months and weekdays
    monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
	monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
	weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
	weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
	weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
	showWeekdaysShort: true,
	
	// Today and clear
	today: 'Hoje',
	clear: 'Limpar',
	close: 'OK',
	
    closeOnSelect: true // Close upon selecting a date,
  });

$(function() {
	$(".dropdown-button").dropdown();
	$(".button-collapse").sideNav();
	$('select').material_select();
	alertHideOnEmpty();
});

function alertHideOnEmpty() {
	var text = $('.alert-hide-on-empty').find("p").text();
	if (!text) {
		$('.alert-hide-on-empty').addClass('hidden');
	}
}

$(".close-alert").click(function() {
	$(this).parent().parent().addClass('hidden');
});