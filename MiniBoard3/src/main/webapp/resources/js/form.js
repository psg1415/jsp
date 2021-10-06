$(function() {
	CKEDITOR.replace("content");	
	CKEDITOR.config.height = 300;
	
	$(".addImage").click(function() {
		layer.popup("../popup/upload", 350, 350); //MiniBoard/popup/upload	
	});
});

/** 이미지 업로드 후 처리할 콜백 함수 */
function callbackUploadImages(images){
	if(!images)
		return;
		
	images = images.split("||");
	let html = "";
	images.forEach(function(image){
		html += `<img src='${image}'>`;
	});
	
	CKEDITOR.instances.content.insertHtml(html);
	
	layer.close();
}