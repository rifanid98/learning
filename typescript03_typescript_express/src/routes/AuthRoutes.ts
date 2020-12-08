import BaseRoute from './BaseRoute';
import AuthController from "../controllers/AuthController";

class AuthRoutes extends BaseRoute {
    public routes(): void {
        this.router.post("/login", AuthController.login);
        this.router.post("/register", AuthController.register);
    }
}

export default new AuthRoutes().router;