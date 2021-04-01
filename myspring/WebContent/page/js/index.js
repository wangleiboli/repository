/**
 * 
 */

$().ready(function() {

	/**
	 * 数字输入框
	 */
	$('body').on('keyup change', 'input.num', function() {
		// debugger;
		var value = $(this).val().replace(/[^\d]/g, '');
		value *= 1;
		value = value == 0 ? '' : value;
		$(this).val(value);
		// console.log(e.type);
	});

	/**
	 * 缓存读取配置目录
	 */
	var pathname = localStorage.getItem('pathname');
	if (pathname) {
		$('#pathname').val(pathname);
	}

	/**
	 * 读取
	 */
	$('#read').on('click', function() {
		var pathname = $('#pathname').val();
		// 配置目录写缓存
		localStorage.setItem('pathname', pathname);

		var data = new FormData();

		data.append('pathname', pathname);
		$.each($('#itemFile')[0].files, function() {
			data.append('files', this);
		});

		$.ajax({
			url: 'item/readConfig.do',
			type: 'POST',
			dataType: 'json',
			data: data,
			processData: false,// 上传文件
			contentType: false,// 上传文件
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

			data['configFileList[' + index + '].filePath'] = $(this).find('.filePath').text();

		});

		sortItem();

		$('.item').each(function(index) {

			data['itemguolvList[' + index + '].objname'] = $(this).find('.ObjName').text();
			data['itemguolvList[' + index + '].bsell'] = $(this).find('.bSell>input[type="checkbox"]').is(':checked');
			data['itemguolvList[' + index + '].bstore'] = $(this).find('.bStore>input[type="checkbox"]').is(':checked');
			data['itemguolvList[' + index + '].bdrop'] = $(this).find('.bDrop>input[type="checkbox"]').is(':checked');
			data['itemguolvList[' + index + '].iqianghuacishu'] = $(this).find('.iQiangHuaCishu>input[type="text"]').val();
			data['itemguolvList[' + index + '].imasu'] = $(this).find('.iMaSu>input[type="text"]').val();
			data['itemguolvList[' + index + '].ifangyu'] = $(this).find('.iFangyu>input[type="text"]').val();
			data['itemguolvList[' + index + '].igongji'] = $(this).find('.iGongji>input[type="text"]').val();
			data['itemguolvList[' + index + '].ishenshangliuliang'] = $(this).find('.iShenshangliuliang>input[type="text"]').val();
			data['itemguolvList[' + index + '].iwujiangji'] = $(this).find('.iWujiangji>input[type="text"]').val();
			data['itemguolvList[' + index + '].ilev'] = $(this).find('.iLev>input[type="text"]').val();
			data['itemguolvList[' + index + '].blevGt'] = $(this).find('.iLev>select').val();
			data['itemguolvList[' + index + '].type'] = $(this).find('.types>select.type').val();
			data['itemguolvList[' + index + '].subtype'] = $(this).find('.types>select.subType').val();
			data['itemguolvList[' + index + '].seq'] = index + 1;

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

	/**
	 * 角色行绑定事件
	 */
	$('.roles').on('click', '.role', function() {
		$('.role').removeClass('select');
		$(this).addClass('select');
	});

	/**
	 * 物品行绑定联动事件
	 */
	$('.items').on('click', '.item', function() {
		$('.item').removeClass('select');
		$(this).addClass('select');

		$('#ObjName').val($(this).find('.ObjName').text());
		$('#bSell').prop('checked', $(this).find('.bSell input').prop('checked'));
		$('#bStore').prop('checked', $(this).find('.bStore input').prop('checked'));
		$('#bDrop').prop('checked', $(this).find('.bDrop input').prop('checked'));
		$('#iShenshangliuliang').val($(this).find('.iShenshangliuliang input').val());
		$('#iQiangHuaCishu').val($(this).find('.iQiangHuaCishu input').val());
		$('#iGongji').val($(this).find('.iGongji input').val());
		$('#iFangyu').val($(this).find('.iFangyu input').val());
		$('#iWujiangji').val($(this).find('.iWujiangji input').val());
		$('#iMaSu').val($(this).find('.iMaSu input').val());
		$('#bLev_gt').val($(this).find('.iLev select').val());
		$('#iLev').val($(this).find('.iLev input').val());
	});

	/**
	 * 类型选择联动
	 */
	var types = {
		'A_神兵': ['A_90级', 'B_100级', 'C_110级', 'D_120级', 'E_130级', 'F_140级'],
		'B_神装': ['A_90级', 'B_100级', 'C_110级', 'D_120级', 'E_130级', 'F_140级'],
		'C_武器': ['A_短兵', 'B_长兵', 'C_重兵', 'D_射击', 'E_双手', 'F_其他'],
		'D_装备Ⅰ': ['A_头盔', 'B_铠甲', 'C_鞋', 'D_马', 'E_装饰品'],
		'E_装备Ⅱ': ['A_小盾', 'B_盾', 'C_护腕', 'D_披风', 'E_内衣'],
		'F_物品及书籍': ['A_使用道具', 'B_配方单', 'C_技能书', 'D_士兵', 'E_武魂', 'F_兵符', 'G_杂项'],
		'G_扮装类': ['A_扮装头盔', 'B_扮装铠甲', 'C_扮装鞋', 'D_全身造型', 'E_扮装披风', 'F_扮装马']
	};
	$('.items').on('change', '.type', function() {

		var select_type = $(this);
		var type = select_type.val();

		if (type == '') {
			select_type.next().html('<option value=""></option>');
			select_type.next().hide();
		} else {

			select_type.next().html('<option value=""></option>');
			$.each(types[type], function(index, value) {
				select_type.next().append('<option value="' + value + '">' + value.substring(2) + '</option>');
			});
			select_type.next().show();
		}

	});

	/**
	 * 删除物品
	 */
	$('.right>.title').on('click', '.delete', function() {
		$('.items').empty();
	});
	$('.items').on('click', '.delete', function() {
		$(this).parent().remove();
	});

	/**
	 * 卖丢单选
	 */
	$('.items').on('click', '.bSell>input, .bDrop>input', function() {

		if ($(this).prop('checked')) {

			if ($(this).parent().hasClass('bSell')) {
				$(this).parent().siblings('.bDrop').children('input').prop('checked', false);
			} else {
				$(this).parent().siblings('.bSell').children('input').prop('checked', false);
			}
		}
	});
	$('#bSell, #bDrop').on('click', function() {

		if ($(this).prop('checked')) {

			if ($(this).prop('id') == 'bSell') {
				$('#bDrop').prop('checked', false);
			} else {
				$('#bSell').prop('checked', false);
			}
		}
	});

	/**
	 * 排序按钮
	 */
	$('.right>.title>div.types>label').on('click', sortItem);

	/**
	 * 位移按钮绑定点击事件
	 */
	$('.toolbar>div').on('click', function(e) {

		if ($(this).hasClass('top')) {

			$('.item.select').each(function() {
				var first = $(this).siblings(':first');
				first.before($(this));
				showItem($(this));
			});
		} else if ($(this).hasClass('up')) {

			$('.item.select').each(function() {
				var prev = $(this).prev();
				$(this).after(prev);
				showItem($(this));
			});
		} else if ($(this).hasClass('down')) {

			$('.item.select').each(function() {
				var next = $(this).next();
				$(this).before(next);
				showItem($(this));
			});
		} else if ($(this).hasClass('bottom')) {

			$('.item.select').each(function() {
				var last = $(this).siblings(':last');
				last.after($(this));
				showItem($(this));
			});
		}

		// 阻止默认事件和冒泡事件
		// return false;
		// 阻止默认事件但是允许冒泡事件
		// e.preventDefault();
		// 阻止冒泡但是允许默认事件
		// e.stopPropagation();
	});

	/**
	 * 增
	 */
	$('#add').on('click', function() {
		var ObjName = $.trim($('#ObjName').val());
		if (ObjName == '') {
			return;
		}

		if (!$('#bSell').prop('checked') && !$('#bStore').prop('checked') && !$('#bDrop').prop('checked')) {
			$('#bSell').prop('checked', true);
		}

		var exist = false;
		$('.item>.ObjName').filter(function() {

			exist = $.trim($(this).text()) == ObjName ? true : exist;
			return $.trim($(this).text()) == ObjName;

		}).each(function() {

			$(this).parent().find('.bSell input').prop('checked', $('#bSell').prop('checked'));
			$(this).parent().find('.bStore input').prop('checked', $('#bStore').prop('checked'));
			$(this).parent().find('.bDrop input').prop('checked', $('#bDrop').prop('checked'));
			$(this).parent().find('.iShenshangliuliang input').val($('#iShenshangliuliang').val());
			$(this).parent().find('.iQiangHuaCishu input').val($('#iQiangHuaCishu').val());
			$(this).parent().find('.iGongji input').val($('#iGongji').val());
			$(this).parent().find('.iFangyu input').val($('#iFangyu').val());
			$(this).parent().find('.iWujiangji input').val($('#iWujiangji').val());
			$(this).parent().find('.iMaSu input').val($('#iMaSu').val());
			$(this).parent().find('.iLev select').val($('#bLev_gt').val());
			$(this).parent().find('.iLev input').val($('#iLev').val());

			$(this).parent().trigger('click');
			showItem($(this).parent());

		});

		if (!exist) {
			var itemguolvList = new Array();
			var data = {
				ObjName: $.trim($('#ObjName').val()),
				bSell: $('#bSell').prop('checked'),
				bStore: $('#bStore').prop('checked'),
				bDrop: $('#bDrop').prop('checked'),
				iShenshangliuliang: $('#iShenshangliuliang').val(),
				iQiangHuaCishu: $('#iQiangHuaCishu').val(),
				iGongji: $('#iGongji').val(),
				iFangyu: $('#iFangyu').val(),
				iWujiangji: $('#iWujiangji').val(),
				iMaSu: $('#iMaSu').val(),
				bLev_gt: $('#bLev_gt').val() == 'true' ? true : false,
				iLev: $('#iLev').val()
			};
			itemguolvList.push(data);

			var html_item = $('#item').render(itemguolvList);
			$('#items').prepend(html_item);

			$('.items>.item:first').trigger('click');
			showItem($('.items>.item:first'));
		}

	});

	/**
	 * 删
	 */
	$('#delete').on('click', function() {
		$('.items>.item').removeClass('select');

		var ObjName = $.trim($('#ObjName').val());
		if (ObjName == '') {
			return;
		}

		$('.item>.ObjName').filter(function() {

			return $.trim($(this).text()) == ObjName;

		}).each(function() {

			$(this).parent().remove();

		});

	});

	/**
	 * 查
	 */
	$('#query').on('click', function() {
		$('.items>.item').removeClass('select');

		var ObjName = $.trim($('#ObjName').val());
		if (ObjName == '') {
			return;
		}

		$('.item>.ObjName').filter(function() {

			return $.trim($(this).text()) == ObjName;

		}).each(function() {

			$(this).parent().trigger('click');
			showItem($(this).parent());

		});

	});

	/**
	 * 清空
	 */
	$('#reset').on('click', function() {
		$('.items>.item').removeClass('select');

		$('#ObjName').val('');
		$('#bSell').prop('checked', false);
		$('#bStore').prop('checked', false);
		$('#bDrop').prop('checked', false);
		$('#iShenshangliuliang').val('');
		$('#iQiangHuaCishu').val('');
		$('#iGongji').val('');
		$('#iFangyu').val('');
		$('#iWujiangji').val('');
		$('#iMaSu').val('');
		$('#bLev_gt').val('false');
		$('#iLev').val('');
	});

	/**
	 * 滚动窗口中显示item
	 */
	function showItem(item) {
		var itemLineHeight = 19;
		var height = $('.items').height();
		var positionTop = item.position().top;
		var top = item.index() * 19;

		if (positionTop < itemLineHeight || positionTop > height) {
			$('.items').scrollTop(top - (height - itemLineHeight) / 2);
		}
	};

	/**
	 * item排序
	 */
	function sortItem() {
		var domArray = $('#items>.item');

		domArray.sort(function(a, b) {

			var type_a = $(a).find('.types>.type').val();
			var type_b = $(b).find('.types>.type').val();
			var subType_a = $(a).find('.types>.subType').val();
			var subType_b = $(b).find('.types>.subType').val();
			var ObjName_a = $(a).find('.ObjName').text();
			var ObjName_b = $(b).find('.ObjName').text();

			var prename_a = ObjName_a.length >= 2 ? ObjName_a.substring(0, 2) : ObjName_a;
			var prename_b = ObjName_b.length >= 2 ? ObjName_b.substring(0, 2) : ObjName_b;

			if (type_a == type_b) {
				if (subType_a == subType_b) {
					if (type_a == 'A_神兵' || type_a == 'B_神装' || type_a == 'E_装备Ⅱ') {
						return 0;
					}
					if (subType_a == 'F_兵符') {
						return 0;
					}
					if (prename_a == prename_b) {
						return 0;
					} else {
						if (ObjName_a == prename_b) {
							return 0;
						} else if (ObjName_a > prename_b) {
							return 1;
						} else {
							return -1;
						}
					}
				} else if (subType_a > subType_b) {
					return 1;
				} else {
					return -1;
				}
			} else if (type_a > type_b) {
				return 1;
			} else {
				return -1;
			}

		});

		$('#items').html(domArray);
	}

});
