
$(function() {
$("#update").datepicker({

dateFormat: 'dd-mm-yy',
changeMonth: true,
changeYear: true,
yearRange: '1980:2006',
minDate: new Date(1980,0,1),
maxDate: new Date(2006,11,31)
});
});
