window.onload = function(){

    if(document.getElementById("login")) {
		const $login = document.getElementById("login");
		$regist.onclick = function() {
			location.href = "/jsp/member/regist";
		}
	}
}