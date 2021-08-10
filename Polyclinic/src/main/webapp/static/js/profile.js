let passportKey = ['passportId', 'firstName','lastName','codeOfIssuing',
    'passportNum','nationality','birthDate','sex','issueDate','expiryDate','birthPlace']
let addressKey = ['city', 'country', 'zipCode', 'street']
let url1 = "http://localhost:8080/Polyclinic-1.0-SNAPSHOT//diseaseHistory/" + sessvars.login
let url2 = "http://localhost:8080/Polyclinic-1.0-SNAPSHOT/users/" + sessvars.login
console.log(url1)

async function sendRequest(method, url,body=null) {
    const headers = {
        'Content-type': 'application/json'
    }
    if(body !== null) {
        body = JSON.stringify(body)
    }
    return await fetch(url, {
        method: method,
        body: body,
        headers: headers
    }).then(response => {
        if(response.ok) {
            console.log(method + " - ОК")
            if (method === 'GET') {
                return response.json()
            }
            return response.status
        } else {
            return response.json().then(error => {
                const e = new Error('Что-то пошло не так')
                e.data = error
                throw e
            })
        }


    })
}

function sendInput(id, selectors) {
    let inputBody = {};
    let address = {};
    let passport = {};


    let elements = document.getElementById(id);
    selectors.forEach( selectors => {
        let selector =  elements.querySelectorAll(selectors)
        console.log(selector)
        selector.forEach( input => {
            if(input.value !== null) {
                if(addressKey.indexOf(input.id) !== -1)  {
                    address[input.id] = input.value
                } else if(passportKey.indexOf(input.id) !== -1) {
                    passport[input.id] = input.value
                } else {
                    inputBody[input.id] = input.value
                }
            }
        })
    })
    inputBody["address"] = address
    inputBody["passport"] = passport
    sendRequest('PUT', url2, inputBody).then(response => {
        if (response === 202) {
            alert("принято")
        }
        if(response === 204) {
            alert("пустая форма")
        }
        if (response >= 400) {
            alert("ошибка")
        }

    })

}

function convertDate(date) {
    return date === null ? null : new Date(date).toISOString().substr(0, 10);
}

window.addEventListener("DOMContentLoaded", () => {

    sendRequest('GET',url1).then(response => {
        createMyMedCardHtml(response)
    })

    sendRequest('GET',url2).then(response => {
        createProfileHtml(response)
    })

    function getElement(id) {
        return document.getElementById(id);
    }


    function createMyMedCardHtml(data) {

        // let page = sessvars.pageMedCard;
        // const notesOnPage = 10;
        // let start = (page - 1) * notesOnPage;
        // let end = notesOnPage + start;

        let count = 0;
        let div = document.createElement('div');
        div.innerHTML =
            data.forEach((e) => {
                count++;
                let p = document.createElement('p');
                p.innerHTML ='<p><details>\n' +
                    ' <p><summary>' + count + ') ' + convertDate(e.sickWith) + ' - ' + convertDate(e.sickBefore) + ' (' + e.disease.diseaseName + ')' + '</summary></p>\n' +
                    '<p> Symptoms: ' + e.disease.symptoms + '</p>' +
                    '<p> Other Info: ' + e.disease.diseaseInfo + '</p>' +
                    '</details> </p>'
                getElement('list-medCard').appendChild(p);
            });

        // div.innerHTML =
        //     '<nav aria-label="disease-history-page-navigation">\n' +
        //     '  <ul class="pagination">\n' +
        //     '    <li class="page-item disabled">\n' +
        //     '      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>\n' +
        //     '    </li>\n' +
        //     '    <li class="page-item"><a class="page-link" href="?page=1">1</a></li>\n' +
        //     '    <li class="page-item active" aria-current="1">\n' +
        //     '      <a class="page-link" href="?page=2">2</a>\n' +
        //     '    </li>\n' +
        //     '    <li class="page-item"><a class="page-link" href="?page=3">3</a></li>\n' +
        //     '    <li class="page-item">\n' +
        //     '      <a class="page-link" href="#">Next</a>\n' +
        //     '    </li>\n' +
        //     '  </ul>\n' +
        //     '</nav></div>';
        // getElement('list-medCard').appendChild(div)



        const buttons = document.querySelectorAll(".btn");
        const handlerClick = (event) => {
            if (parseInt(event.target.dataset.num) === 1) {
                createHtmlElement(div, 'list-medCard', data)
            }
        }
        buttons.forEach(button => {
            button.addEventListener('click', handlerClick)
        });
    }


    function createProfileHtml(data) {
        let div = document.createElement('div')
        div.innerHTML =
            '<p>Login: ' + data.login + '</p>' +
            '<p>Tel: ' + data.tel + '</p>' +
            '<p>Email: ' + data.email + '</p>' +
            '<p> <details>\n' +
            '<p><summary>Passport</summary></p>\n' +
            '<p>Passport ID: ' + data.passport.passportId +  '</p>\n' +
            '<p>First Name: ' + data.passport.firstName +  '</p>\n' +
            '<p>Last Name: ' + data.passport.lastName +  '</p>\n' +
            '<p>Сode of issuing: ' + data.passport.codeOfIssuing +  '</p>\n' +
            '<p>Passport №: ' + data.passport.passportNum +  '</p>\n' +
            '<p>Nationality: ' + data.passport.nationality +  '</p>\n' +
            '<p>Birth date: ' + convertDate(data.passport.birthDate) +  '</p>\n' +
            '<p>Sex: ' + data.passport.sex +  '</p>\n' +
            '<p>Issue date: ' + convertDate(data.passport.issueDate) +  '</p>\n' +
            '<p>Expiry date: ' + convertDate(data.passport.expiryDate) +  '</p>\n' +
            '<p>Birth Place: ' + data.passport.birthPlace +  '</p>\n' +
            '</details> </p>' +
            '<p><details>\n' +
            ' <p><summary>Address</summary></p>\n' +
            '<p>City: ' + data.address.city + '</p>' +
            '<p>Country: ' + data.address.country + '</p>' +
            '<p>Street: ' + data.address.street + '</p>' +
            '<p>ZipCode: ' + data.address.zipCode + '</p>' +
            '</details> </p>' +
            '<div class="col-12"><button data-num="2" type="submit" class="btn btn-primary">изменить</button></div>';
        getElement('list-profile').appendChild(div);

        const buttons = document.querySelectorAll(".btn");
        const handlerClick = (event) => {
            if (parseInt(event.target.dataset.num) === 2) {
                createHtmlElement(div, 'list-profile', data)
            }
        }
        buttons.forEach(button => {
            button.addEventListener('click', handlerClick)
        });
    }


    async function getCountryList(element) {
        const data = await sendRequest('GET',"static/js/country.json");
        data.country.forEach((e) => {
            let options = document.createElement("option")
            options.innerHTML = '<option value="' + e + '">' + e + '</option>'
            document.getElementById(element).appendChild(options)
        })}

    function createHtmlElement(element,idElement) {
        element.innerHTML = '<form id="form1" class="row g-3" onsubmit=sendInput("form1",["input","select"]) >\n' +
            '  <div class="col-md-6">\n' +
            '    <label for="email"  class="form-label">Email</label>\n' +
            '    <input type="email" placeholder="email" class="form-control" id="email">\n' +
            '  </div>\n' +
            '  <div class="col-md-6">\n' +
            '    <label for="password"  class="form-label">Password</label>\n' +
            '    <input type="password" class="form-control" id="password">\n' +
            '  </div>\n' +
            '  <div class="col-12">\n' +
            '    <label for="street" class="form-label">Street</label>\n' +
            '    <input type="text" class="form-control" id="street" placeholder="1234 Main St">\n' +
            '  </div>\n' +
            '  <div class="col-md-6">\n' +
            '    <label for="city" class="form-label">City</label>\n' +
            '    <input type="text" class="form-control" id="city">\n' +
            '  </div>\n' +
            '  <div class="col-md-4">\n' +
            '    <label for="country" class="form-label">Country</label>\n' +
            '    <select id="country" class="form-select">\n' +
            '     <option selected></option>' +
            +  getCountryList('country').then() +
            '    </select>\n' +
            '  </div>\n' +
            '<div class="col-md-2">\n' +
            '    <label for="zipCode" class="form-label">Zip</label>\n' +
            '    <input type="text" class="form-control" id="zipCode">\n' +
            '</div>\n' +
            '<div class="col-md-4">\n' +
            '    <label for="firstName" class="form-label">First name</label>\n' +
            '    <input type="text" class="form-control" id="firstName">\n' +
            '</div>\n' +
            '<div class="col-md-4">\n' +
            '    <label for="lastName" class="form-label">Last name</label>\n' +
            '    <input type="text" class="form-control" id="lastName">\n' +
            '</div>\n' +
            '<div class="col-md-4">\n' +
            '    <label for="birthPlace" class="form-label">Birth Place</label>\n' +
            '    <select id="birthPlace" class="form-select">\n' +
            '     <option selected></option>' +
            +  getCountryList('birthPlace').then() +
            '    </select>\n' +
            '</div>' +
            '<div class="col-md-4">\n' +
            '    <label for="passportId" class="form-label">Passport ID</label>\n' +
            '    <input type="text" class="form-control" id="passportId">\n' +
            '</div>' +
            '<div class="col-md-4">\n' +
            '    <label for="passportNum" class="form-label">Passport Number</label>\n' +
            '    <input type="text" class="form-control" id="passportNum">\n' +
            '</div>' +
            '<div class="col-md-2">\n' +
            '    <label for="nationality" class="form-label">Nationality</label>\n' +
            '    <input type="text" class="form-control" id="nationality">\n' +
            '</div>' +
            '<div class="col-md-2">\n' +
            '    <label for="sex" class="form-label">Sex</label>\n' +
            '    <select class="form-select" id="sex" required>\n' +
            '      <option selected disabled value=""></option>\n' +
            '      <option value="M">Male</option>\n' +
            '      <option value="F">Female</option>\n' +
            '    </select>\n' +
            '</div>\n' +
            '<div class="col-md-3">\n' +
            '    <label for="issueDate" class="form-label">Passport issue Date</label>\n' +
            '    <input type="date" class="form-control" id="issueDate">\n' +
            '</div>' +
            '<div class="col-md-3">\n' +
            '    <label for="expiryDate" class="form-label">Passport expiry Date</label>\n' +
            '    <input type="date" class="form-control" id="expiryDate">\n' +
            '</div>' +
            '<div class="col-md-3">\n' +
            '    <label for="birthDate" class="form-label">Birth Date</label>\n' +
            '    <input type="date" class="form-control" id="birthDate">\n' +
            '</div>' +
            '<div class="col-md-3">\n' +
            '    <label for="codeOfIssuing" class="form-label">Code of issuing</label>\n' +
            '    <input type="text" class="form-control" id="codeOfIssuing">\n' +
            '</div>' +
            '  <div class="col-12">\n' +
            '    <button type="submit" data-num="2" class="btn btn-primary">сохранить</button>\n' +
            '  </div>\n' +
            '</form>'
        document.getElementById(idElement).appendChild(element);
    }

});