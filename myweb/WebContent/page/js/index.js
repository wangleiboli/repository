/**
 * 
 */

$().ready(function() {

	/**
	 * 数字输入框
	 */
	$('input.num').on('keyup change', function() {
		//debugger;
		var value = $(this).val().replace(/[^\d]/g, '');
		$(this).val(value);
		//	console.log(e.type);
	});

	$('#read').on('click', function() {
		var pathname = $('#pathname').val();
		var data = { pathname: pathname };

		$.ajax({
			url: 'item/readConfig.do',
			type: 'POST',
			dataType: 'json',
			data: data,
			contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
			success: function(result) {
				console.log(result);
				var html_role = $("#role").render(result.configFileList);
				$("#roles").html(html_role);

				var html_item = $("#item").render(result.itemguolvList);
				$("#items").html(html_item);
			}
		});

	});
});