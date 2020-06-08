export class HashUtil {

    public static hash(data: string) {
        let hashval = 0;
        for (let i = 0; i < data.length; i++) {
            let c = data.charCodeAt(i);
            hashval = (hashval<<4) | c;
        }
        return hashval;
    }

}
