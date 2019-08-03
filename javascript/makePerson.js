let Person = function (firstAndLast) {
    
    let firstAndLast_ = firstAndLast;

    this.getFullName = () => {
        return firstAndLast_;
    };

    this.getFirstName = () => {
        const temp = firstAndLast_.slice(0);
        const arr = temp.split(' ');
        return arr[0];
    }

    this.getLastName = () => {
        const temp = firstAndLast_.slice(0);
        const arr = temp.split(' ');
        return arr[1];
    }

    this.setFirstName = (first) => {
        if (typeof first === 'string') {
            firstAndLast_ = firstAndLast_.split(' ')[0] = `${first + ' ' + firstAndLast_.split(' ')[1] }`;
        }
    }

    this.setLastName = (last) => {
        if (typeof last === 'string') {
            firstAndLast_ = firstAndLast_.split(' ')[0] = `${firstAndLast_.split(' ')[0] + ' ' + last}`;
            
        }
    }

    this.setFullName = (firstAndLast) => {
        if (typeof firstAndLast === 'string') {
            firstAndLast_ = firstAndLast;
        }
    }
};

let bob = new Person('Bob Ross');
console.log( bob.getFullName() );
bob.setLastName("Curry")
console.log( bob.getFullName() );



