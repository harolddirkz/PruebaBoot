function guardar() {

	$.ajax({
		url : 'saveAlumno',
		type : 'POST',
		data : {

		},
		success : function(res) {
			var message = res.status;
			if (message === "1") {
				alert("me mandaste 1");
				location.reload();
			}
		}
	});
};