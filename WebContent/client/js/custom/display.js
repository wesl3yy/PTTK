let listView = false;
let listViewClick = () => {
	$('.item-product').addClass("item-product-list");
	$('.thumb').addClass("float-left");
	$('.info').addClass("info-list");
	$('.list-product').addClass("list-product-center");
	listView = true;
}

let gridViewClick = () => {
	$('.item-product').removeClass("item-product-list");
	$('.thumb').removeClass("float-left");
	$('.info').removeClass("info-list");
	$('.list-product').removeClass("list-product-center");
	listView = false;
}

$(document).ready(function(){
	$('.list-view').click(listViewClick);
	$('.grid-view').click(gridViewClick);
});