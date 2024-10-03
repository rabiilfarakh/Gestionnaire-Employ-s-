
        function validateForm() {
            let name = document.getElementById("name").value;
            let email = document.getElementById("email").value;
            let phone = document.getElementById("phone").value;
            let department = document.getElementById("departement").value;
            let post = document.getElementById("poste").value;

            const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            const phoneRegex = /^\+?[0-9]{10,15}$/;

            if (!name) {
                alert("Le nom doit être rempli.");
                return false;
            }
            if (!email || !emailRegex.test(email)) {
                alert("Veuillez entrer un e-mail valide.");
                return false;
            }
            if (!phone || !phoneRegex.test(phone)) {
                alert("Veuillez entrer un numéro de téléphone valide.");
                return false;
            }
            if (!department) {
                alert("Le département doit être rempli.");
                return false;
            }
            if (!post) {
                alert("Le poste doit être rempli.");
                return false;
            }

            return true;
        }
