# Ch-1: Array Problem Solving

**Taking input in JavaScript: Ostad**

```javascript
// Rotate The Array
function main (input) {
    const lines = input.split("\r\n");
    const textMetaData = lines[0];
    const textData = lines[1];

    const metaData = textMetaData.split(" ");
    const n = Number(metaData[0]);
    const k = Number(metaData[1]);

    const data = textData.split(" ");

    if(k===0) {
        const temp = data[n-1];
        for(let i=n-1; i>0; i--) {
            data[i]=data[i-1];
        }
        data[0]=temp;
    } else if(k===1) {
        const temp = data[0];
        for(let i=0; i<n-1; i++) {
            data[i]=data[i+1];
        }
        data[n-1]=temp;
    }

    const output = data.join(" ");
    console.log(output);
}

let input = "";
process.stdin.on('data', (chunk) => {
    input += chunk;
});

process.stdin.on('end', () => {
    main(input.trim());
});
```

**Find Duplicate [See](https://codemama.io/codetest/participate/5e4cd069-90e3-450b-be7d-9234ac1b5d5d/problems/find-duplicate)**

```java
function main (input) {
    const [n, textData] = input.split("\r\n");
    const data = textData.split(" ");

    for(let i=0; i<n-1; i++) {
        for(let j=i+1; j<n; j++ ) {
            if(data[i]==data[j]){
                console.log(data[i]);
                return 0;
            }

        }
    }
    
}
```