import bcrypt from 'bcrypt';

export const passwordHash = (password: String): Promise<String> => {
    return bcrypt.hash(password, 10);
}