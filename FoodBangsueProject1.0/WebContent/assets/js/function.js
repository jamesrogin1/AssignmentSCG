function calculate() {
	const number = [0,5,9,15,23,0,0];
	
	for(let i=0; i<number.length; i++) {
		if(i == 0 && i < 1) {
			number[i] = i + 1 + 2 * (i + 1);
		} else if(i > 4) {
			number[i] = 2 * ((i + 1) - 1);
			number[i] = number[i-1] + number[i];
		} 
	}
	
	$("#inputX").val(number[0]);
	$("#inputY").val(number[5]);
	$("#inputZ").val(number[6]);
	$("#result").show();
};