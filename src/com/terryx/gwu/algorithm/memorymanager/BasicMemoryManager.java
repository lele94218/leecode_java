package com.terryx.gwu.algorithm.memorymanager;

import java.util.*;

/**
 * @author taoranxue on 10/31/16 6:24 PM.
 */
public class BasicMemoryManager {
    private Comparator<Handle> HANDLE_BY_VALUE = new Comparator<Handle>() {
        @Override
        public int compare(Handle p, Handle q) {
            return p.value - q.value;
        }
    };

    private Comparator<Handle> HANDLE_BY_LENGTH = new Comparator<Handle>() {
        @Override
        public int compare(Handle p, Handle q) {
            return q.length - p.length;
        }
    };

    private class Block {
        int length;
        int handle;
        int x;
        int y;
        char[] name;

        public Block() {
            this.length = -1;
            this.handle = -1;
        }


        public Block(int length, int handle, int x, int y, char[] name) {
            this.length = length;
            this.handle = handle;
            this.x = x;
            this.y = y;
            this.name = name;
        }

        public void free() {
            this.length = -1;
            this.handle = -1;
        }
    }

    private class Handle {
        int value;
        int length;

        public Handle(int value, int length) {
            this.value = value;
            this.length = length;
        }
    }

    private class Memory {
        private int size;
        private final int MEMORY_SIZE;
        private final int RECORD_NUM;
        private final List<Handle> freeBlocks = new ArrayList<>();
        private final List<Block> blocks = new LinkedList<>();

        public Memory(int memorySize, int recordNum) {
            this.MEMORY_SIZE = memorySize;
            this.RECORD_NUM = recordNum;
            Handle handle = new Handle(0, MEMORY_SIZE);
            freeBlocks.add(handle);

            for (int i = 0; i < RECORD_NUM; ++i) {
                blocks.add(new Block());
            }

            this.size = 0;
        }

        public boolean insert(int id, int x, int y, String name) {
//            System.out.println("insert");
            if (id < 0 || id > size) return false;
            if (id < size) remove(id);

            Collections.sort(freeBlocks, HANDLE_BY_LENGTH);
            Handle maxLengthHandle = freeBlocks.get(0);
            int length = 9 + name.length();
            if (maxLengthHandle.length < length) return false;

            Block insertBlock = new Block(length, maxLengthHandle.value, x, y, name.toCharArray());
            Handle freeBlock = new Handle(maxLengthHandle.value + length, maxLengthHandle.length - length);
            freeBlocks.remove(maxLengthHandle);
            freeBlocks.add(freeBlock);
            blocks.set(id, insertBlock);
            if (id == size) {
                size++;
            }

            return true;
        }

        public boolean remove(int id) {
            if (id < 0 || id >= size) return false;

//            System.out.println("remove");
            Block removeBlock = blocks.get(id);
            int handleValue = removeBlock.handle;
            int lengthValue = removeBlock.length;
            Handle handle = new Handle(handleValue, lengthValue);
            removeBlock.free();
            freeBlocks.add(handle);

            Collections.sort(freeBlocks, HANDLE_BY_VALUE);
            int k = 0;
            while (k < freeBlocks.size() - 1) {
                if (freeBlocks.get(k).value + freeBlocks.get(k).length == freeBlocks.get(k + 1).value) {
                    freeBlocks.get(k).length += freeBlocks.get(k + 1).length;
                    freeBlocks.remove(k + 1);
                    continue;
                }
                ++k;
            }

            return true;
        }

        public void print() {
            Collections.sort(freeBlocks, HANDLE_BY_LENGTH);
            for (int i = 0; i < RECORD_NUM; ++i) {
                if (blocks.get(i).length == -1) {
                    System.out.format("record %d: no record at %d\n", i, i);
                } else {
                    System.out.format("record %d: %d %d %s: handle %d\n", i, blocks.get(i).x, blocks.get(i).y,
                            String.valueOf(blocks.get(i).name), blocks.get(i).handle);
                }
            }

            System.out.format("\nFree block\n\n");
            for (Handle handle : freeBlocks) {
                System.out.format("[%d, %d] %d bytes\n", handle.value, handle.value + handle.length - 1, handle.length);
            }
            System.out.println();
        }

        public void print(int id) {
            Block block = blocks.get(id);
            if (block.length != -1)
                System.out.format("print %d: %d %d %s: handle %d\n\n", id, block.x, block.y,
                        String.valueOf(block.name), block.handle);
            else
                System.out.format("print %d: no record at %d\n\n", id, id);
        }
    }


    public static void main(String args[]) {
        if (args.length > 2) System.err.format("Usage: java memman <pool-size> <num-recs> <command-file>\n");
        BasicMemoryManager basicMemoryManager = new BasicMemoryManager();
        BasicMemoryManager.Memory memory =
                basicMemoryManager.new Memory(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            String[] inputs = input.split(" ");
            if (inputs[0].equals("print")) {
                if (inputs.length > 1) {
                    memory.print(Integer.parseInt(inputs[1]));
                } else {
                    memory.print();
                }
            } else if (inputs[0].equals("insert")) {
                int id = Integer.parseInt(inputs[1]);
                int x = Integer.parseInt(inputs[2]);
                int y = Integer.parseInt(inputs[3]);
                String name = inputs[4];
                boolean ret = memory.insert(id, x, y, name);
                if (ret) System.out.format("insert %d %d %d %s: successful\n", id, x, y, name);
                else System.out.format("insert %d %d %d %s: unsuccessful due to no memory available\n", id, x, y, name);
            } else if (inputs[0].equals("remove")) {
                int id = Integer.parseInt(inputs[1]);
                boolean ret = memory.remove(id);
                if (ret) System.out.format("remove %d: successful\n", id);
                else System.out.format("remove %d: unsuccessul due to out-of-range recnum\n", id);
            }

        }
    }

}
