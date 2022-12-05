$(document).ready(function() {

	//add field
	$("#add").on("click", function() {
		var temp = $(".symptom li").length;
		$(".symptom").append(`
            <li>
                <div class="mb-3">
                    <label for="symptom" class="form-label">Day ${temp} symptom</label>
                    <textarea name ="symptom" class="form-control" id="symptom${temp}" rows="3"></textarea>
                </div>
            </li>`);
	});

	// get doctors
	let doctors;
	$.get(
		"http://localhost:8080/OnlineHealthMonitoring/DoctorAvailableList",
		{ Type: "DoctorTranfer" },
		function(data) {
			doctors = data;
			ShowDoctorAvailable(doctors);
			ShowDoctors(doctors);
		}, "Json"
	);
	function ShowDoctorAvailable(doctorList) {
		let _str = 'Select a doctor:';
		for (let p of doctorList) {
			_str += `
            <li class="doctor">
            <div class="d-flex align-items-center">
                <div class="flex-shrink-0">
                    <img src="${p.picture}" alt="ava">
                </div>

                <div class="flex-grow-1 ms-3">
                    <h3 id="drName">${p.fullName}</h3>
                    Doctor specialize in ${p.speciality}
                </div>

                <!-- isSelect -->
                <span class="badge bg-success rounded-pill" id="check">
                    <i class="fa fa-check" aria-hidden="true"></i>
                </span>
            </div>
        </li>
                    `;
		}
		;
		$('.availUsers').html('');
		$('.availUsers').append(_str);
	};
	function ShowDoctors(doctorList) {
		let _option = '';
		for (let p of doctorList) {
			_option += `<option value="${p.fullName}">${p.fullName}</option>`
		}
		$('#doctor').append(_option);
	}
	$("#reset").click(function() {
		window.location = "consult-patient.html";
	});

	//fill the patient information
	let patient;
	$.get(
		"http://localhost:8080/OnlineHealthMonitoring/UserManage",
		{ Type: "UserTranfer" },
		function(data) {
			patient = data;
			fillInfor(patient);
		}, "Json"
	);
	function fillInfor(patient) {
		$('#nameInput').val(patient.fullName);
		$('#phoneInput').val(patient.phoneNumber);
		$('#emailInput').val(patient.email);
	}
	;

	//select dr
	var doc = document.getElementsByClassName("doctor");
	console.log(doc);
	console.log(doc.length);
	var i;
	for (i = 0; i < doc.length; i++) {
		console.log(doc[i]);
		doc[i].onclick = function() {
			$(this).toggleClass("selected");
			$("#check", this).toggle();
			//get doctor name
			alert($("#drName", this).html());
		};
	}
});
function saveDraf() {
	var doc = new jsPDF('p', 'pt', 'a4', true);
	doc.fromHTML($('#htmlContent').get(0), 15, 15, {
		'width': 500
	},
		function() {
			doc.save('payment.pdf');
		});
}
;
function sendConsult() {
	$("#htmlContent").submit();
	var temp = $(".symptom li").length;
	for (let i = 0; i < temp; i++) {
		console.log($(`#symptom${i}`).val());
	}
}
;

