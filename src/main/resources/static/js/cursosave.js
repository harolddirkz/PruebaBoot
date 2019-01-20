function guardar() {
	var nombrecurso = $("#nombrecurso").val();
	var sigla = $("#sigla").val();

	console.log(nombrecurso + " " + sigla);

	$.ajax({
		url : 'saveCurso',
		type : 'POST',
		data : {
			"nombrecurso" : nombrecurso,
			"sigla" : sigla

		},
		success : function(res) {
			/*var message = res.status;
			if (message === "1") {
				alert("me mandaste 1");
				location.reload();
			}*/
		}
	});

};