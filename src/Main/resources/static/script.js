let accountCreateContent;
let accountReadContent;
let accountUpdateContent;
let accountDeleteContent;
let bookCreateContent;
let bookReadContent;
let bookUpdateContent;
let bookDeleteContent;
let borrowedCreateContent;
let borrowedReadContent;
let borrowedUpdateContent;
let borrowedDeleteContent;


function accountCreateClick() {
    accountCreateContent = {
                "forename": document.forms["AccountCreateInput"]["forename"].value,
                "surname": document.forms["AccountCreateInput"]["surname"].value,
                "address":document.forms["AccountCreateInput"]["address"].value ,
                "age":document.forms["AccountCreateInput"]["age"].value
    };

    fetch('http://localhost:8085/account/createAccount', {
        method: 'POST',
        headers: {
            'accept': 'application/json, text/plane, */*',
            'content-type': 'application/json'
        },
        body: JSON.stringify(accountCreateContent)
    })
        .then((res) => res.json())
        .then(data => document.getElementById('output').innerText = JSON.stringify(data))
}

function accountReadClick() {
    accountReadContent = {"id": document.forms["AccountReadInput"]["accountID"].value};

    fetch('http://localhost:8085/account/getAccount')
        .then((res) => res.json())
        .then((data) => {
            let output;
            data.forEach(function(account){
                output += `id: ${account.accountID}, name: ${account.forename} ${account.surname}, address: ${account.address}, age: ${account.age} \n`;
            });
            document.getElementById('output').innerText = output;
        })
}

function accountUpdateClick() {
    accountUpdateContent = {
        "accountID": document.forms["accountUpdateInput"]["accountID".value],
        "forename": document.forms["accountUpdateInput"]["forename"].value,
        "surname": document.forms["accountUpdateInput"]["surname"].value,
        "address":document.forms["accountUpdateInput"]["address"].value ,
        "age":document.forms["accountUpdateInput"]["age"].value
    };

    fetch(`http://localhost:8085/account/updateAccount/${accountUpdateContent.accountID}`, {
        method: 'PUT',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(accountUpdateContent)
    })
        .then((res) => res.json())
        .then((data) => document.getElementById('output').innerText = JSON.stringify(data))

}

function accountDeleteClick() {
    accountDeleteContent = {"id": document.forms["accountDeleteInput"]["accountID"].value};

    fetch(`http://localhost:8085/account/deleteAccount/${accountDeleteContent.id}`, {
        method: 'DELETE'
    })
        .then((res) => res.json())
        .then((dats) => document.getElementById('output').innerHTML = "done")
}

function bookCreateClick() {
    bookCreateContent = {
                "title": document.forms["bookCreateInput"]["title"].value,
                "author": document.forms["bookCreateInput"]["author"].value,
    };
    alert(JSON.stringify(bookCreateContent));

    fetch('http://localhost:8085/book/createBook', {
        method: 'POST',
        headers: {
            'accept': 'application/json, text/plane, */*',
            'content-type': 'application/json'
        },
        body: JSON.stringify(bookCreateContent)
    })
        .then((res) => res.json())
        .then(data => document.getElementById('bookOutput').innerText = JSON.stringify(data))
}

function bookReadClick() {
    bookReadContent = {"id": document.forms["bookReadInput"]["bookID"].value};

    fetch('http://localhost:8085/book/getBooks')
        .then((res) => res.json())
        .then((data) => {
            let output;
            data.forEach(function(book){
                output += `id: ${book.bookID}, title: ${book.title}, author: ${book.author}`;
            });
            document.getElementById('bookOutput').innerText = output;
        })
}

function bookUpdateClick() {
    bookUpdateContent = {
         "bookID": document.forms["bookUpdateInput"]["bookID"].value,
        "title": document.forms["bookUpdateInput"]["title"].value,
        "author": document.forms["bookUpdateInput"]["author"].value,
    };

    fetch(`http://localhost:8085/book/updateBook/${bookUpdateContent.bookID}`, {
        method: 'PUT',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(bookUpdateContent)
    })
        .then((res) => res.json())
        .then((data) => document.getElementById('bookOutput').innerText = JSON.stringify(data))

}

function bookDeleteClick() {
    bookDeleteContent = {"id": document.forms["bookDeleteInput"]["bookID"].value};

    fetch(`http://localhost:8085/book/deleteBook/${bookDeleteContent.id}`, {
        method: 'DELETE'
    })
        .then((res) => res.json())
        .then((data) => document.getElementById('output').innerHTML = "done")
}

function borrowedCreateClick() {
    borrowedCreateContent = {
        "accountIDFK": document.forms["borrowedCreateInput"]["accountIDFK"].value,
        "bookIDFK": document.forms["borrowedCreateInput"]["bookIDFK"].value,
    };

    fetch('http://localhost:8085/borrowed/createBorrowed', {
        method: 'POST',
        headers: {
            'accept': 'application/json, text/plane, */*',
            'content-type': 'application/json'
        },
        body: JSON.stringify(borrowedCreateContent)
    })
        .then((res) => res.json())
        .then(data => document.getElementById('borrowedOutput').innerText = JSON.stringify(data))
}

function borrowedReadClick() {
    borrowedReadContent = {"id": document.forms["borrowedReadInput"]["borrowedID"].value};

    fetch('http://localhost:8085/borrowed/getBorrowed')
        .then((res) => res.json())
        .then((data) => {
            let output;
            data.forEach(function(borrowed){
                output += `id: ${borrowed.borrowedID}, title: ${borrowed.accountIDFK}, author: ${borrowed.bookIDFK}`;
            });
            document.getElementById('borrowedOutput').innerText = output;
        })
}

function borrowedUpdateClick() {
    borrowedUpdateContent = {
        "borrowedID": document.forms["borrowedUpdateInput"]["borrowedID"].value,
        "accountIDFK": document.forms["borrowedUpdateInput"]["accountIDFK"].value,
        "bookIDFK": document.forms["borrowedUpdateInput"]["bookIDFK"].value,
    };

    fetch(`http://localhost:8085/borrowed/updateBorrowed/${borrowedUpdateContent.borrowedID}`, {
        method: 'PUT',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(borrowedUpdateContent)
    })
        .then((res) => res.json())
        .then((data) => document.getElementById('borrowedUpdateOutput').innerText = JSON.stringify(data))
}

function borrowedDeleteClick() {
    borrowedDeleteContent = {"id": document.forms["borrowedDeleteInput"]["borrowedID"].value};

    fetch(`http://localhost:8085/book/deleteBook/${borrowedDeleteContent.id}`, {
        method: 'DELETE'
    })
        .then((res) => res.json())
        .then((data) => document.getElementById('output').innerHTML = "done")

}