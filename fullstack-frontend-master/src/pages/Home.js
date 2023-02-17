import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [users, setUsers] = useState([]);

  const { id } = useParams();
  
  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8081/users/all");
    setUsers(result.data);
  };

  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8081/users/${id}`);
    loadUsers();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">Id User</th>
              <th scope="col">Last name</th>
              <th scope="col">First name</th>
              <th scope="col">Date of birth</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr>
                <th> {user.idUtilisateur}
                </th>
                <td>{user.nom}</td>
                <td>{user.prenom}</td>
                <td>{user.date_naissance}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/viewuser/${user.idUtilisateur}`}
                  >
                    View
                  </Link>                 
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteUser(user.idUtilisateur)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
