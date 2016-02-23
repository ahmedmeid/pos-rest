// The root URL for the RESTful services
var rootURL = "/product";

var currentProduct;

// Register listeners
$('#btnSearch').click(function() {
	viewData($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e) {
	if (e.which == 13) {
		viewData($('#searchKey').val());
		e.preventDefault();
		return false;
	}
});

function findByBarcode(barcode) {
	console.log('findByBarcode: ' + barcode);
	$.ajax({
		type : 'GET',
		url : rootURL + '/' + barcode,
		crossDomain : true,
		dataType : "jsonp",
		success : function(data) {
			console.log('findByBarcode success: ' + data.description);
			currentProduct = data;
			renderDetails(currentProduct);
		}
	});
}

function renderDetails(product) {
	$('#productId').val(product.productId);
	$('#description').val(product.description);
	$('#price').val(product.price);
	$('#serialnum').val(product.serialnum);
}

function viewData(barcode) {
	console.log('viewing table: ' + barcode);
	$.ajax({
	    url: 'ajax_data.json',
		success : function(data) {
			$('my-ajax-table').dynatable({
				dataset : {
					records : data
				}
			});
		}
	});
}