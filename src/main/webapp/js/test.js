// The root URL for the RESTful services
var rootURL = "/product";

$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		findByBarcode($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

function findByBarcode(barcode) {
	console.log('findByBarcode: ' + barcode);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + barcode,
		crossDomain: true,
		dataType: "jsonp",
		success: function(data){
			console.log('findByBarcode success: ' + data.description);
			$('#t01 tr.searchRow').before(productJsonToRow(data));
			$('#searchKey').val('');
			$('#lbl_total').html(parseFloat(parseFloat($('#lbl_total').html()) + parseFloat(data.price)));
		}
	});
}


function productJsonToRow(product)
{
	var row = '<tr>';
	row = row.concat('<td>'+product.barcode+'</td>');
	row = row.concat('<td>'+product.description+'</td>');
	row = row.concat('<td>'+product.price+'</td>');
	row = row.concat('<td>'+product.serialnum+'</td>');
	row = row.concat('<td><input type="text" value = "1"/></td>');
	row = row.concat('</tr>');
	return row;
}