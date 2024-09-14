console.log("Script loaded");

let currentTheme = getTheme();
//initial -->
changeTheme();

//Todo
function changeTheme(){
	//set to web page
	//changePageTheme(currentTheme, currentTheme);
	//document.querySelector("html").classList.add(currentTheme);
	
	//set the listener to change theme button
	const changeThemeButton = document.querySelector('#theme_change_button');
	//changeThemeButton.querySelector("span").textContent = 
	//	currentTheme == "light" ? "Dark" : "Light";
	changeThemeButton.addEventListener('click', (event) => {
		let oldTheme = currentTheme;
		console.log("change theme button clicked");
		
		if(currentTheme == "dark"){
			//theme light
			currentTheme = "light";
		}else{
			//theme dark
			currentTheme = "dark";
		}
		//update in localStroage
		changePageTheme(currentTheme, oldTheme);
	});
}

//set theme to localstorage
//localstorage store the data
function setTheme(theme){
	localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme(){
	let theme = localStorage.getItem("theme");
	//tornary operator
	return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme){
	setTheme(currentTheme);
	//remove the current theme
	document.querySelector("html").classList.remove(oldTheme);
			
	//set the current theme
	document.querySelector("html").classList.add(theme);
			
	//change the text of button
	document.querySelector('#theme_change_button').querySelector("span").textContent = 
	theme == "light" ? "Dark" : "Light";
}