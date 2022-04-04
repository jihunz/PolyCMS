$(function() {
	ajax_article_count({ type: "ref_count" });

	//함수 '일원화' -> '파라미터'만 변경하여 '요청' 종류를 '변경' -> 컨트롤러는 동일한 요청만 받고 서비스에서 type에 따라 다른 dao의 메서드 실행
	$("#good_count button").click(() => ajax_article_count({ type: "good_count" }));
	
	$("#bad_count button").click(() => ajax_article_count({ type: "bad_count" }));

});

// abusing 차단

function ajax_article_count(item) {
	$.ajax("", {
        method: "POST",
		contentType: "application/json",
		dataType: "json",
		data: JSON.stringify(item),
        success: result => {
			console.log(`[성공] ${item.type} 수 증가: ${result.type}`);
			
			// text() 함수를 통해 값만 바꿔주면 되므로 dom을 삭제 후 재생성할 필요 없음
			const count = $(`#${item.type} p`).text();
			//count의 text가 문자열이므로 Number() 통해 숫자로 변환
			$(`#${item.type} p`).text(Number(count) + 1);
			
		},
        error: xhr => alert(`[실패] ${item.type} 수 증가: ${xhr}`)
    });
}