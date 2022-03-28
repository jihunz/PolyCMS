$(function() {
	count();

	// $("#goodBtn").click(() => goodCount());
	
	// $("#badBtn").click(() => badCount());
});

const currLoc = $(location).attr("href");
const locArr = currLoc.split("/");
const articleId = locArr[8];

const item = {
	type: "ref_count",
}

function count() {
	$.ajax("", {
        method: "POST",
		contentType: "application/json",
		dataType: "json",
		data: JSON.stringify(item),
        success: result => console.log(`[성공] 조회 수 증가: ${result}`),
        error: xhr => alert(`[실패] 조회 수 증가: ${xhr}`)
    });
}

// function goodCount() {
//     $.ajax(`./${articleId}/goodCount`, {
//         method: "POST",
// 		data: 'none',
// 		contentType: false,
//         success: result => console.log(result),
//         error: xhr => alert(`오류 발생: ${xhr.statusText}`)
//     });
// }

// function badCount() {
//     $.ajax(`./${articleId}/badCount`, {
//         method: "POST",
// 		data: 'none',
// 		contentType: false,
//         success: result => console.log(result),
//         error: xhr => alert(`오류 발생: ${xhr.statusText}`)
//     });
// }

// function getCounts() {
// 	let num;
// 	let count;

//     $.ajax(`./${articleId}/item`, {
//         method: "GET",
// 		data: 'none',
// 		contentType: false,
//         success: result => {
//             num.text(result.count);
// 			return;
//         },
//         error: xhr => { alert(`오류 발생: ${xhr.statusText}`) }
//     });
// }