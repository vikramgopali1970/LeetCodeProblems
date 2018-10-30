package LeetProblem;

import CrackingTheCodingInterview.StringPermutation;

public class Main {




    public static void main(String[] args){

        /**
         * Peaked Array
         */
//            PeakedArray pArr = new PeakedArray();
//            pArr.execAlg(new int[]{1,2,3,4,5,6,5,4,3,2,1},0,11);

        /**
         * PeakedArray problem #38  :: Easy
         */
//            CountAndSay prob = new CountAndSay();
//            System.out.println(prob.CountAndSaySoln(4));

        /**
         * Combination Sum #39 :: Medium
         */
//        CombinationSum cSum = new CombinationSum();
//        System.out.println(cSum.execAlgo(new int[]{1,2,4,6},10));

        /**
         * Symmetric Tree :: Explore problems
         */
//        SymmetricTree sTree = new SymmetricTree();

        /**
         * Kth smallest Element in BST #230 :: Medium
         */
//        kSmallestBST kTree = new kSmallestBST();

        /**
         * Path Sum in BST :: Explore problems
         */
//            PathSum ps = new PathSum();

        /**
         * Number of words that can be formed from given data referring dictionary
         * */
//        NumOfWords nm = new NumOfWords();
//        System.out.println(nm.getWordCount("1223242"));

        /**
         * Jumping blocks equal to or less than the height of the current block and clear the field
         * */
//        BlockJumping bj = new BlockJumping();
//        System.out.println(bj.CrossPossible(new int[]{4,2,0,3,2,2,0}));

        /**
         * Leet Code #11 : Container With Most Water
         * */
//        MaximumWaterContainer mwc = new MaximumWaterContainer();
//        System.out.println(mwc.getMaxWaterVolume(new int[]{1,8,6,2,5,4,8,3,7}));

        /**
         * Leet Code #273 : integer to english words
         * */
//        IntegerToEnglishWords itew = new IntegerToEnglishWords();
//        System.out.println(itew.intToWords(100000));


        /**
         * Leet Code #301 : Remove Invalid Parentheses
         * */
//        RemoveInvalidParanthesis rip = new RemoveInvalidParanthesis();
//        System.out.println(rip.removeInvalidParentheses(")(f"));

        /**
         * Leet Code #253 : Meeting Rooms II
         * */
        MeetingRooms2 mr2 = new MeetingRooms2(new int[]{1,3,10,2,8,11},new int[]{10,19,20,7,12,30});
        System.out.println(mr2.minMeetingRooms());

    }
}
