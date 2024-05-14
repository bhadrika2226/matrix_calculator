package matrix_calculator.matrixop;

public class AdjointOfMatrix{

    public static float[][] adjoint(float [][] arr){
        int order = arr.length;
        float[][] adj = new float [order][order];
        float[][] minor= new float [order-1][order-1];

        if(order==1){
            if(arr[0][0] !=0){
                adj[0][0]=1;
            }
            else{
                adj[0][0]=0;
            }
            return adj;
        }
        //traversing each element of arr to find its cofactor
        for(int i=0;i<order;i++){
            for(int j=0;j<order; j++){
                 int m=0, n=0;
                //traversing to find the minor
                for(int k=0;k<order;k++){
                    for(int l=0;l<order;l++){
                        //skipping the elements of the row and column of the element whose minor is being found
                        if(i!=k && j!=l){
                            minor[m][n++] = arr[k][l];
                        }
                    }
                    //moving to next row only if current row is filled
                    if(n==order-1){
                        m++;
                        n=0;
                    }
                }
                adj[j][i]=  (DeterminantOfMatrix.det(minor,0)*(float)Math.pow(-1,(i+j)));
            }
        }
        return adj;
    }

}