document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('login-form');
  const msg = document.getElementById('login-msg');

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const usuario = {
      username: document.getElementById('username').value,
      senha: document.getElementById('senha').value
    };

    fetch('http://localhost:8080/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(usuario)
    })
      .then(res => res.text())
      .then(data => {
        msg.textContent = data;
        msg.classList.add("fw-bold");
        if (data.includes("sucesso")) {
          msg.classList.add("text-success");
          setTimeout(() => {
            window.location.href = "index.html"; // redireciona
          }, 1500);
        } else {
          msg.classList.add("text-danger");
        }
      })
      .catch(err => {
        msg.textContent = "Erro no servidor!";
        msg.classList.add("text-danger");
      });
  });
});
