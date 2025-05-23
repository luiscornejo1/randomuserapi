import React, { useEffect, useState } from 'react';

function App() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/users')
      .then(res => res.json())
      .then(data => setUsers(data))
      .catch(err => console.error('Error al obtener usuarios:', err));
  }, []);

  return (
    <div style={{ padding: '2rem', fontFamily: 'Arial' }}>
      <h1>Lista de Personas</h1>
      {users.map((user, index) => (
        <div key={index} style={{
          display: 'flex',
          alignItems: 'center',
          border: '1px solid #ccc',
          borderRadius: '10px',
          padding: '1rem',
          marginBottom: '1rem',
          gap: '1rem'
        }}>
          <img src={user.picture} alt="Foto" width="80" height="80" style={{ borderRadius: '50%' }} />
          <div>
            <h3>{user.fullName}</h3>
            <p><strong>Género:</strong> {user.gender}</p>
            <p><strong>Email:</strong> {user.email}</p>
            <p><strong>Ubicación:</strong> {user.location}</p>
            <p><strong>Fecha de nacimiento:</strong> {user.birthDate}</p>
          </div>
        </div>
      ))}
    </div>
  );
}

export default App;
