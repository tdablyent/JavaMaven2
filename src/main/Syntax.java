

public class Syntax {
    public static void main(String[] args) {
        int[] input1 = {1,3,3,7,7};
        int[] input2 = {1,3,3,7,7,8,8};
        int[] input3 = {1,1,3,7,7,9,9};
        int[] input4 = {1,1,7,7,9,9,11,22,22};
        int[] input5 = {1,1,7,7,9,9,22,22,33};
        int[] input6 = {1,1,7,7,8,9,9,22,22};
        int[] input7 = {5};
        int[] input8 = {};
        int[] input9 = null;

        
        System.out.println(findunique(input1));
        System.out.println(findunique(input2));
        System.out.println(findunique(input3));
        System.out.println(findunique(input4));
        System.out.println(findunique(input5));
        System.out.println(findunique(input6));
        System.out.println(findunique(input7));
        System.out.println(findunique(input8));
        System.out.println(findunique(input9));
    }

    static int findunique(int[] input)
    {
        if(input == null) return -1;
        if(input.length == 0) return -1;
        if(input.length == 1) return input[0];

        int begin = 0;
        int end = input.length - 1;
        int length = end + 1;
        int mid = end/2;
        while(begin < end)
        {
            if(((length-1)/2) % 2 == 0)
            {
                if(input[mid] != input[mid + 1] && input[mid] != input[mid - 1])
                    return input[mid];
                if(input[mid] == input[mid + 1])
                {
                    begin = mid;
                }
                else if (input[mid] == input[mid - 1])
                {
                    end = mid;
                }
            }
            else
            {
                if(input[mid] != input[mid + 1] && input[mid] != input[mid - 1])
                    return input[mid];
                if(input[mid] == input[mid + 1])
                {
                    end = mid -1 ;

                }
                else if (input[mid] == input[mid - 1])
                {
                    begin = mid + 1;
                }
            }
            mid = (begin + end ) /2;
            length = end - begin + 1;
        }

        return input[mid];


    }
}
