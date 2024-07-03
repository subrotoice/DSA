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

**Taking input in Java: Ostad**

```java
// Rotate The Array
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] data = new int[n];

        for(int i=0; i<n; i++) {
            data[i]=scanner.nextInt();
        }

        // System.out.println(n);
        // System.out.println(k);
        // System.out.println(Arrays.toString(data));

        if(k==0) {
            int temp = data[n-1];
            for(int i=n-1; i>0; i--) {
                data[i]=data[i-1];
            }
            data[0]=temp;
        } else if(k==1) {
            int temp = data[0];
            for(int i=0; i<n-1; i++) {
                data[i]=data[i+1];
            }
            data[n-1]=temp;
        }

        for(int i=0; i<n; i++) {
            System.out.print(data[i] + " ");
        }

    }
}
```