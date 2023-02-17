package ubo.fr.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubo.fr.entities.Utilisateur;
import ubo.fr.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

    @CrossOrigin("http://localhost:3000/")
    @RestController
    @RequestMapping("/users")
    public class userController {
        @Autowired
        UserRepository userRepository;
        @GetMapping("/all")
        public List<Utilisateur> getUsers() {
            return userRepository.findAll();
        }

        @GetMapping("/{id}")
        public Utilisateur getuser(@PathVariable Integer id) {
            return userRepository.findById(id).orElseThrow(RuntimeException::new);
        }

        @PostMapping("/adduser")
        public ResponseEntity createUser(@RequestBody Utilisateur user) throws URISyntaxException {
            Utilisateur savedUser = userRepository.save(user);
            return ResponseEntity.created(new URI("/users/" + savedUser.getIdUtilisateur())).body(savedUser);
        }
        @PutMapping("/{id}")
        public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody Utilisateur user) {
            Utilisateur currentUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
            currentUser.setNom(user.getNom());
            currentUser.setPrenom(user.getPrenom());
            currentUser = userRepository.save(user);
            return ResponseEntity.ok(currentUser);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteUser(@PathVariable Integer id) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
}
