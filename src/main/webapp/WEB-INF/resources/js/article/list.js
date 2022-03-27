function viewCount() {
    
    $.ajax(`./viewCount/${ariticle.id}`, {
        method: "POST",
		data: 1,
		contentType: false,
		processData: false,
        success: result => {
            console.log("count success")
			return;
        },
        error: xhr => { alert(`오류 발생: ${xhr.statusText}`) }
    });
}