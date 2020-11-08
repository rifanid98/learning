/**
 * Interface.
 * 
 * - An interface is the same as an abstract class, 
 *   but it is more of a contract about the properties 
 *   and methods used by the class that implements it.
 * - Interface does not support access modifier other than public.
 * - Interfaces can be implemented in classes or variables as data types
 */

namespace interface_ {

    /** 
     * Interface 
     */
    interface IPhone {
        name: String;
        home(): void;
    }

    // implement interface in class
    class AndroidPhone implements IPhone {
        public name: String;

        constructor(name: String) {
            this.name = name;
        }

        public menu(): void {
            console.log('menu phone');
        }

        public back(): void {
            console.log('back phone');
        }

        public home(): void {
            console.log('home phone');
        }
    }

    class IOSPhone implements IPhone {
        public name: String;

        constructor(name: String) {
            this.name = name;
        }

        public home(): void {
            console.log('home phone');
        }
    }

    const redmi = new AndroidPhone('Redmi Note 5');
    redmi.back();
    redmi.menu();
    redmi.home();

    console.log()

    const iPhone = new IOSPhone('I Phone 12 Pro Max');
    iPhone.home();

    // Android Application
    class SomeApplication {
        private phone: AndroidPhone;

        constructor(phone: AndroidPhone) {
            this.phone = phone;
        }

        public menu(): void {
            console.log('menu app')
        }

        public back(): void {
            this.phone.back();
        }

        public home(): void {
            this.phone.home();
        }
    }

    const myApp = new SomeApplication(redmi);
    myApp.menu();
    myApp.back();
    myApp.home();

    // const myApp2 = new SomeApplication(iPhone); // iPhone is not an android phone

    /** 
     * Interface Optional Property 
     */
    interface IBioadata {
        name: String;
        age?: Number;
        address: String;
    }

    /**
     * Interface as data types
     */
    // with age
    let adninBiodata: IBioadata = {
        name: 'Adnin',
        age: 22,
        address: 'Kp. Sinagar'
    }

    // without age
    let icaBioadata: IBioadata = {
        name: 'Siti Nurhaliza',
        address: 'Kalimantan Timur'
    }

    adninBiodata.name = 'Adnin Rifandi Sutanto Putra'; // name of adninBiodata is not readonly
    console.log(adninBiodata);
    console.log(icaBioadata);

    /**
     * Interface as return types
     */
    function getBioadata(biodata: IBioadata): IBioadata {
        return biodata;
    }
    console.log(getBioadata(icaBioadata));


    /** 
     * Interface Readonly Modifier 
     */
    interface IBioadata2 {
        readonly name: String;
        readonly age?: Number;
        readonly address: String;
    }

    let rifandiBiodata: IBioadata2 = {
        name: 'Rifandi',
        age: 22,
        address: 'Kp. Sinagar'
    }

    // rifandiBiodata.name = 'Adnin Rifandi'; // name of rifandiBiodata is readonly

    /**
     * Interface Inheritance
     */
    interface IFullBiodata extends IBioadata {
        job: String;
        hobby: String;
    }

    const adninFullBioadata: IFullBiodata = {
        name: 'Adnin Rifandi Sutanto Putra',
        age: 22,
        address: 'Kp. Sinagar',
        job: 'Programmer',
        hobby: 'Coding'
    }
    console.log(adninFullBioadata);

    /**
     * Interface Implements Class
     */
    class Bioadata implements IFullBiodata {
        job: String;
        hobby: String;
        name: String;
        age?: Number | undefined;
        address: String;

        constructor(
            name: String,
            age: Number,
            address: String,
            job: String,
            hobby: String,
            ){
            this.name = name;
            this.age = age;
            this.address = address;
            this.job = job;
            this.hobby = hobby;
        }

        public biodata(): void {
            console.log('Bioadata');
            console.log(`Name\t: ${this.name}`);
            console.log(`Age\t: ${this.age}`);
            console.log(`Address\t: ${this.address}`);
            console.log(`Job\t: ${this.job}`);
            console.log(`Hobby\t: ${this.hobby}`);
        }
    }

    const myBiodata = new Bioadata(
        'Adnin',
        22,
        'Kp. Sinagar',
        'Programmer',
        'Coding'
    );
    myBiodata.biodata();
}