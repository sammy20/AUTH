export class User{

    private id: number;
    private username: string;
    private password: string;
    private role: string;
    private email: string;
    
    public getId(): number{
        return this.id;
    }
    public setId(id: number): void{
        this.id = id;
    }

    public getUsername(): string{
        return this.username;
    }
    public setUsername(username: string): void{
        this.username = username;
    }

    public getPassword(): string{
        return this.password;
    }
    public setPassword(password: string): void{
        this.password = password;
    }

    public getRole(): string{
        return this.role;
    }
    public setRole(role: string): void{
        this.role = role;
    }

    public getEmail(): string{
        return this.email;
    }
    public setEmail(email: string): void{
        this.email = email;
    }
}