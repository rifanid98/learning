/**
 * Setter & Getter
 */
class SetterGetter {
    private on: boolean = false;

    set _on(value: boolean) {
        this.on = value;
    }

    get _on(): boolean {
        return this.on;
    }
}

let setterGetter = new SetterGetter();
console.log(setterGetter._on);  // getter
setterGetter._on = true;        // setter
console.log(setterGetter._on);  // getter