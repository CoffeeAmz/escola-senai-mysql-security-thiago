document.addEventListener('DOMContentLoaded', () => {
  const apiUrl = 'http://localhost:8080/professores';
  const tbody = document.getElementById('professor-tbody');
  const form = document.getElementById('professor-form');
  const professorId = document.getElementById('professor-id');
  const nomeInput = document.getElementById('nome');
  const emailInput = document.getElementById('email');
  const telefoneInput = document.getElementById('telefone');

  // Função para carregar professores
  function carregarProfessores() {
    fetch(apiUrl)
      .then(res => res.json())
      .then(data => {
        tbody.innerHTML = '';
        data.forEach(prof => {
          const tr = document.createElement('tr');
          tr.innerHTML = `
            <td>${prof.nome}</td>
            <td>${prof.email}</td>
            <td>${prof.telefone}</td>
            <td>


              <button class="btn btn-warning btn-sm me-2"
                onclick="editarProfessor(${prof.id}, '${prof.nome}', '${prof.email}', '${prof.telefone}')">
                  <i class="fas fa-edit"></i>
              </button>


              <button class="btn btn-danger btn-sm" onclick="excluirProfessor(${prof.id})">
                <i class="fa fa-trash" aria-hidden="true"></i>
              </button>


            </td>
          `;
          tbody.appendChild(tr);
        });
      })
      .catch(err => {
        console.error('Erro ao buscar professores:', err);
        alert('Erro ao carregar professores.');
      });
  }

  // Função salvar (cadastrar ou atualizar)
  form.addEventListener('submit', (e) => {
    e.preventDefault();

    const professor = {
      nome: nomeInput.value,
      email: emailInput.value,
      telefone: telefoneInput.value
    };

    if (professorId.value) {
      // Atualizar
      fetch(`${apiUrl}/${professorId.value}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(professor)
      })
      .then(() => {
        alert('Professor atualizado com sucesso!');
        form.reset();
        professorId.value = '';
        carregarProfessores();
      });
    } else {
      // Criar
      fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(professor)
      })
      .then(() => {
        alert('Professor cadastrado com sucesso!');
        form.reset();
        carregarProfessores();
      });
    }
  });

  // Expor funções globais
  window.editarProfessor = (id, nome, email, telefone) => {
    professorId.value = id;
    nomeInput.value = nome;
    emailInput.value = email;
    telefoneInput.value = telefone;
  };

  window.excluirProfessor = (id) => {
    if (confirm('Deseja excluir este professor?')) {
      fetch(`${apiUrl}/${id}`, { method: 'DELETE' })
        .then(() => {
          alert('Professor excluído!');
          carregarProfessores();
        });
    }
  };

  // Inicializar
  carregarProfessores();
});