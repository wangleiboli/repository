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

	/**
	 * 读取
	 */
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
				//console.log(result);
				var html_role = $('#role').render(result.configFileList);
				$('#roles').html(html_role);

				var html_item = $('#item').render(result.itemguolvList);
				$('#items').html(html_item);
			}
		});

	});


	$('#save').on('click', function() {

		var data = new Array();

		$('.item').each(function() {

			var item = {
				objname: $(this).find('.ObjName').text(),
				bsell: $(this).find('.bSell input[type="checkbox"]').is(":checked"),
				bstore: $(this).find('.bStore input[type="checkbox"]').is(":checked"),
				bdrop: $(this).find('.bDrop input[type="checkbox"]').is(":checked"),
				iqianghuacishu: $(this).find('.iQiangHuaCishu input[type="text"]').val() * 1,
				imasu: $(this).find('.iMaSu input[type="text"]').val() * 1,
				ifangyu: $(this).find('.iFangyu input[type="text"]').val() * 1,
				igongji: $(this).find('.iGongji input[type="text"]').val() * 1,
				ishenshangliuliang: $(this).find('.iShenshangliuliang input[type="text"]').val() * 1,
				iwujiangji: $(this).find('.iWujiangji input[type="text"]').val() * 1,
				ilev: $(this).find('.iLev input[type="text"]').val() * 1,
				blevGt: $(this).find('.iLev select').val() == 'true' ? true : false
			};

			data.push(item);
		});
		console.log({ itemguolvList: data });
		$.ajax({
			url: 'item/saveConfig.do',
			type: 'POST',
			dataType: 'json',
			data: JSON.stringify(data),
			contentType: 'application/json;charset=UTF-8',
			success: function(result) {
				console.log(result);
			}
		});

	});
});