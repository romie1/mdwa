/**
 * See s10.html
 *
 * Requires
 *	access to the DOM
 */

function callback() {
	if (this.readyState == XMLHttpRequest.DONE) {
		let target = document.getElementById('target');

		if (this.status != 200) {
			target.textContent = `[Something went wrong: ${this.status}]`;
			return;
		}

		target.textContent = this.responseText;
	}
}

document.getElementById('btnCheck').onclick = () => {
	let name = document.getElementById('name');
	let target = 's10/checker2?user=' + name.value;

	let request = new XMLHttpRequest();
	request.onload = callback;
	request.open('GET', target);
	request.send();
};
