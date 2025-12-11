public class Error {

    // createUser seguindo Clean Code:
    // Usa exceções para fluxo de erro (UserExistsException / UserNotFoundException)
    public User createUser(User user) {

        try {
            // Se loadUser NÃO lançar exceção, o usuário já existe
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        }
        catch (UserNotFoundException exception) {
            // Usuário não existe → fluxo normal continua
            // Caso necessário: logar ou enriquecer o contexto
        }

        resolveGroup(user);
        return userRepository.save(user);
    }


    // Validação com contexto adequado na exceção
    public void validate(String id) {
        if (ownerRepo.count(id) == 0) {
            throw new ValidationException(
                "O id '" + id + "' não existe no repositório ou não foi informado corretamente."
            );
        }
    }


    // Versão equivalente do createUser, também correta
    public User createUserAlternative(User user) {

        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        }
        catch (UserNotFoundException exception) {
            // Fluxo normal: usuário não existe
        }

        resolveGroup(user);
        return userRepository.save(user);
    }

}