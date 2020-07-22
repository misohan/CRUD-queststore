const username  = document.getElementById("name")
const password  = document.getElementById("password")
const login = document.getElementById("login-form")
const errorElement = document.getElementById("message")


login.addEventListener('LOGIN', (e) => {
    let message = []
    if (name.value === "" || name.value == null){
        message.push("Name is required")
    }

    if(message.length > 0){
        e.preventDefault()
        errorElement.innerText = message.join(', ')
    }
})
