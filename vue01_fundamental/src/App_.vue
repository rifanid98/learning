<template>
    <div>
        <!-- <E01DeclarativeRendering /> -->
        <!-- <E02Methods /> -->
        <!-- <E03VModel /> -->
        <!-- <E04ConditionalRendering /> -->
        <!-- <E05ForLoop /> -->
        <!-- <E06Component /> -->
        <!-- <E07LifeCycle /> -->
        <!-- <E08VOnce /> -->
        <!-- <E08VHtml /> -->
        <!-- <E10Computed /> -->
        <!-- <E11ComputedSetterGetter /> -->
        <!-- <E12Watcher /> -->
        <!-- <E13DynamicCSSPropertyValue /> -->

        <!-- E14Emits -->
            <!-- <E14Emits @child-click="getChildClick" v-bind:value="false"/>
            <E14Emits @child-click-with-value="getChildClickWithValue" v-bind:value="true"/> -->

        <!-- E15Refs -->
            <!-- <E15Refs ref="E15Refs" />
            <button @click="execE15RefsMethods">execute E15Refs methods</button> -->
        
        <!-- E16ParentStateUpdate -->
            <!-- <div>{{ message }}</div> -->

            <!-- CARA 1 -->

            <!-- :model-value="message" is getter -->
            <!-- @update:model-value="message = $event" is setter -->
            <!-- <E16ParentStateUpdate 
                :model-value="message" 
                @update:model-value="message = $event" 
            /> -->
            
            <!-- CARA 2 -->
            <!-- <E16ParentStateUpdate v-model="message" /> -->

        <!-- E17ParentStateUpdateComputed -->
            <!-- v-model="message" is getter + setter -->
            <!-- <div>{{ message }}</div> -->
            <!-- <E17ParentStateUpdateComputed v-model="message" /> -->

        <!-- E18SlotVue -->
        <!-- default slot -->
            <!-- <E18SlotVue>
                <span>sisipan</span>    
            </E18SlotVue> -->
        <!-- named slot -->
            <!-- <E18SlotVue>
                <template v-slot:default>slot <br></template>
                <template v-slot:slot1>slot1 <br></template>
                <template v-slot:slot2>slot2 <br></template>
            </E18SlotVue> -->

        <!-- E19SlotPropsVue -->
            <!-- <E19SlotPropsVue>
                <template v-slot:slot-props="props">
                    slot props "props": -> props.data: <b>{{ props.data }}</b> <br>
                    slot props "props": -> props.slotProps: <b>{{ props.slotProps }}</b> <br>
                </template>
                <template v-slot:divider><br></template>
                <template v-slot:slot-props-data="{ data, slotProps }">
                    slot props{data}: -> data: <b>{{ data }}</b> <br>
                    slot props {slotProps}: -> slotProps: <b>{{ slotProps }}</b> <br>
                </template>
            </E19SlotPropsVue> -->

        <!-- E20GlobalComponent -->
            <!-- <E20GlobalComponent /> -->
    </div>
</template>

<script>
// import E01DeclarativeRendering from "./components/E01DeclarativeRendering.vue";
// import E02Methods from "./components/E02Methods.vue";
// import E03VModel from "./components/E03VModel.vue";
// import E04ConditionalRendering from "./components/E04ConditionalRendering.vue";
// import E05ForLoop from "./components/E05ForLoop.vue";
// import E06Component from "./components/E06Component.vue";
// import E07LifeCycle from "./components/E07LifeCycle.vue";
// import E08VOnce from "./components/E08VOnce.vue";
// import E08VHtml from "./components/E09VHtml.vue";
// import E10Computed from "./components/E10Computed.vue";
// import E11ComputedSetterGetter from "./components/E11ComputedSetterGetter.vue";
// import E12Watcher from "./components/E12Watcher.vue";
// import E13DynamicCSSPropertyValue from "./components/E13DynamicCSSPropertyValue.vue";
// import E14Emits from "./components/E14Emits.vue";
// import E15Refs from "./components/E15Refs.vue";
// import E16ParentStateUpdate from './components/E16ParentStateUpdate.vue';
// import E17ParentStateUpdateComputed from './components/E17ParentStateUpdateComputed.vue';
// import E18SlotVue from './components/E18Slot.vue';
// import E19SlotPropsVue from './components/E19SlotProps.vue';

const App = {
    name: 'App',
    data() {
        return {
            message: 'default message',
            pesan: 'default pesan'
        }
    },
    components: {
        // E01DeclarativeRendering,
        // E02Methods,
        // E03VModel,
        // E04ConditionalRendering,
        // E05ForLoop,
        // E06Component,
        // E07LifeCycle,
        // E08VOnce,
        // E08VHtml,
        // E10Computed,
        // E11ComputedSetterGetter,
        // E12Watcher,
        // E13DynamicCSSPropertyValue,
        // E14Emits,
        // E15Refs,
        // E16ParentStateUpdate,
        // E17ParentStateUpdateComputed,
        // E18SlotVue,
        // E19SlotPropsVue,
    },
    methods: {
        /** E14Emits */
        // getChildClick() {
        //     console.log('child-click clicked');
        // },
        // getChildClickWithValue(value) {
        //     console.log('child-click-with-value clicked, value is : ' + value);
        // },
        /** E15Refs */
        // execE15RefsMethods() {
        //     this.$refs.E15Refs.ExecE15RefsMethods();
        // }
    }
}

export default App;
</script>
