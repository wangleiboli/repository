/**
 * 
 */

$().ready(function() {

	/**
	 * 数字输入框
	 */
	$('input.num').on('keyup change', function() {
		// debugger;
		var value = $(this).val().replace(/[^\d]/g, '');
		$(this).val(value);
		// console.log(e.type);
	});
	
	/**
	 * 缓存读取配置目录
	 */
	var pathname = localStorage.getItem('pathname');
	if(pathname){
		$('#pathname').val(pathname);
	}

	/**
	 * 读取
	 */
	$('#read').on('click', function() {
		var pathname = $('#pathname').val();
		// 配置目录写缓存
		localStorage.setItem('pathname', pathname);
		var data = { pathname: pathname };

		$.ajax({
			url: 'item/readConfig.do',
			type: 'POST',
			dataType: 'json',
			data: data,
			contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
			success: function(result) {
				//console.log(result);
				var html_role = $('#role').render(result.data.configFileList);
				$('#roles').html(html_role);

				var html_item = $('#item').render(result.data.itemguolvList);
				$('#items').html(html_item);
			}
		});

	});

	/**
	 * 保存
	 */
	$('#save').on('click', function() {

		var data = {};
		
		$('.role').each(function(index) {
			
			data['configFileList['+index+'].filePath'] = $(this).find('.filePath').text();

		});

		$('.item').each(function(index) {
			
			data['itemguolvList['+index+'].objname'] = $(this).find('.ObjName').text();
			data['itemguolvList['+index+'].bsell'] = $(this).find('.bSell input[type="checkbox"]').is(':checked');
			data['itemguolvList['+index+'].bstore'] = $(this).find('.bStore input[type="checkbox"]').is(':checked');
			data['itemguolvList['+index+'].bdrop'] = $(this).find('.bDrop input[type="checkbox"]').is(':checked');
			data['itemguolvList['+index+'].iqianghuacishu'] = $(this).find('.iQiangHuaCishu input[type="text"]').val();
			data['itemguolvList['+index+'].imasu'] = $(this).find('.iMaSu input[type="text"]').val();
			data['itemguolvList['+index+'].ifangyu'] = $(this).find('.iFangyu input[type="text"]').val();
			data['itemguolvList['+index+'].igongji'] = $(this).find('.iGongji input[type="text"]').val();
			data['itemguolvList['+index+'].ishenshangliuliang'] = $(this).find('.iShenshangliuliang input[type="text"]').val();
			data['itemguolvList['+index+'].iwujiangji'] = $(this).find('.iWujiangji input[type="text"]').val();
			data['itemguolvList['+index+'].ilev'] = $(this).find('.iLev input[type="text"]').val();
			data['itemguolvList['+index+'].blevGt'] = $(this).find('.iLev select').val();

		});
		
		$.ajax({
			url: 'item/saveConfig.do',
			type: 'POST',
			dataType: 'json',
			data: data,
			contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
			success: function(result) {
				alert(result.status);
			}
		});

	});
});
