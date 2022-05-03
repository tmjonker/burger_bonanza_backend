import $ from 'jquery';

function postMenuItem(values) {

    const menuItem = {
        id: values.id,
        category: values.category, 
        name: values.name,
        description: values.desc,
        price: values.price,
        imgPath: values.img
    }

    $.ajax({
        type: "post",
        url: "http://localhost:8080/api/menu/" + values.id,
        data: JSON.stringify(menuItem),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function(menuItem) {
            alert("Menu Item successfully added...");
        }
    });
}

function signIn(credentials) {

    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/',
        data: JSON.stringify(credentials),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: () => {
            alert("Successfully logged in");
        }
    })
}

export default { postMenuItem, signIn };