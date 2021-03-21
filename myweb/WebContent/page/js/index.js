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
});