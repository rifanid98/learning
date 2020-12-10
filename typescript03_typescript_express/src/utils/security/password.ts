import bcrypt from 'bcrypt';

export const passwordHash = (password: string): Promise<string> => {
    return bcrypt.hash(password, 10);
}

export const passwordCompare = (password1: string, password2: string): Promise<Boolean> => {
    return bcrypt.compare(password1, password2);
}
